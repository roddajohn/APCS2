import java.util.NoSuchElementException;

public class MyDoubleEndedQueue<T> {
    private Object[] data;
    private int[] priority;
    private int head;
    private int tail;
    private int size;
    
    
    public static void main(String[] args) {
	MyDoubleEndedQueue<String> a = new MyDoubleEndedQueue<String>();
	System.out.println(a);
	a.addFirst("i", 0);
	a.addFirst("i", 1);
	a.addFirst("i", 2);
	for (int i = 0; i < 100; i++) {
	    a.addFirst("i", i);
	}
	a.addFirst("i", 0);
	System.out.println(a.removeLargest());
	System.out.println(a);
    }
    
    public MyDoubleEndedQueue() {
	data = new Object[10];
	head = 5;
	tail = 4;
	size = 0;
	priority = new int[10];
	//	for (int i = 0; i < priority.length; i++) {
	//	    priority[i] = Integer.MAX_VALUE;
	//	}
    }

    public String toString() {
	String toReturn = "";
	toReturn += "[";
	for (Object i : data) {
	    toReturn += i + ", ";
	}
	toReturn += "]";
	toReturn += "\n[";
	for (int i : priority) {
	    toReturn += i + ", ";
	}
	toReturn += "]";
	return toReturn;
    }
    
    public void addFirst(T value) {
	if (isFull()) {
	    getAndResize();
	}
	data[tail--] = value;
	if (tail == -1) {
	    tail = data.length - 1;
	}
	size++;
    }

    public void addFirst(T value, int p) {
	if (isFull()) {
	    getAndResize();
	}
	data[tail] = value;
	priority[tail] = p;
	tail--;
	if (tail == -1) {
	    tail = data.length - 1;
	}
	size++;
    }
    public void addLast(T value) {
	if (isFull()) {
	    getAndResize();
	}
	data[head++] = value;
	if (head == data.length) {
	    head = 0;
	}
	size++;
    }
    public void addLast(T value, int p) {
	if (isFull()) {
	    getAndResize();
	}
	data[head] = value;
	priority[head] = p;
	head++;
	if (head == data.length) {
	    head = 0;
	}
	size++;
    }
    public T removeSmallest() {
	int indexOfSmallest = 0;
	for (int i = 0; i < data.length; i++) {
	    if ((priority[i] > priority[indexOfSmallest] && data[i] != null)||data[indexOfSmallest] == null) {
		indexOfSmallest = i;
 	    }
	}
	T toReturn = (T)data[indexOfSmallest];
	eliminateEmpty(indexOfSmallest);
	return toReturn;
    }
    public T removeLargest() {
	int indexOfSmallest = 0;
	for (int i = 0; i < data.length; i++) {
	    if ((priority[i] > priority[indexOfSmallest] && data[i] != null)||data[indexOfSmallest] == null) {
		indexOfSmallest = i;
	    }
	}
	T toReturn = (T)data[indexOfSmallest];
	eliminateEmpty(indexOfSmallest);
	return toReturn;
    }
    public void eliminateEmpty(int index) {
	int i = tail;
	Object previous = null;
	int previousPriority = 0;
	while (i != index) {
	    Object temp = previous;
	    previous = data[i];
	    data[i] = temp;
	    int tempa = previousPriority;
	    tempa = previousPriority;
	    previousPriority = priority[i];
	    priority[i] = tempa;
	    i--;
	    if (i == -1) {
		i = data.length - 1;
	    }
	}
	Object temp = previous;
	previous = data[i];
	data[i] = temp;
	int tempa = previousPriority;
	tempa = previousPriority;
	previousPriority = priority[i];
	priority[i] = tempa;
	size--;
    }
    public T removeFirst() {
        T a;
	if (tail == data.length - 1) {
	    tail = -1;
	    a = (T)data[++tail];
	    data[tail] = null;
	}
	else {
	    a = (T)data[++tail];
	    data[tail] = null;
	}
	size--;
	return a;
    }
    public T removeLast() {
	T a;
	if (head == 0) {
	    head = data.length;
	    a = (T)data[--head];
	    data[head] = null;
	}
	else {
	    a = (T)data[--head];
	    data[head] = null;
	}
	size--;
	return a;
    }   
    public T getFirst() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	if (tail == data.length - 1) {
	    return (T)data[0];
	}
	else {
	    return (T)data[tail + 1];
	}
    }
    public T getLast() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	if (head == 0) {
	    return (T)data[data.length - 1];
	}
	else {
	    return (T)data[head - 1];
	}
    }
	
    public void getAndResize() {
	Object[] hi = new Object[data.length * 2];
	int[] lol = new int[data.length * 2];
	int i = tail;
	int j = 0;
	//	System.out.println("Tail: " + tail);
	//System.out.println("Head: " + head);
	while (i != head) {
	    // System.out.println("i: " + i);
 
	    hi[j] = data[i];
	    lol[j] = priority[i];
	    j++;
	    i--;
	    if (i == -1) {
 		i = data.length - 1;
	    }
	}
	tail = 0;
	head = data.length - 1;
	data = hi;
	priority = lol;
    }
    public boolean isFull() {
	for (Object a : data) {
	    if (a == null) {
		return false;
	    }
	}
	return true;
    }
    public int size() {
	return size;
    } 
}
