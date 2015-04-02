import java.util.NoSuchElementException;

public class MyDoubleEndedQueue<T> {
    private Object[] data;
    private int head;
    private int tail;
    private int size;


    public static void main(String[] args) {
	MyDoubleEndedQueue<Integer> a = new MyDoubleEndedQueue<Integer>();
	System.out.println(a);
	a.addLast(1);
	System.out.println(a.removeFirst());
    }
    
    public MyDoubleEndedQueue() {
	data = new Object[10];
	head = 5;
	tail = 4;
	size = 0;
    }
    public String toString() {
	String toReturn = "";
	toReturn += "[";
	for (Object i : data) {
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
	int i = tail;
	int j = 0;
	//	System.out.println("Tail: " + tail);
	//System.out.println("Head: " + head);
	while (i != head) {
	    // System.out.println("i: " + i);
	    if (i == -1) {
		i = data.length - 1;
	    }
	    hi[j++] = data[i--];
	}
	tail = 0;
	head = data.length - 1;
	data = hi;
    }
    public boolean isFull() {
	for (Object a : data) {
	    if (a == null) {
		return false;
	    }
	}
	return true;
    } 
}
