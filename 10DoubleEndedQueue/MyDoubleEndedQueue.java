import java.util.NoSuchElementException;

public class MyDoubleEndedQueue<T> {
    private Object[] data;
    private int head;
    private int tail;
    private int size;


    public static void main(String[] args) {
	MyDoubleEndedQueue<Integer> a = new MyDoubleEndedQueue<Integer>();
	a.addFirst(1);
	a.addFirst(0);
	a.addLast(2);
	a.addLast(3);
	a.addFirst(1);
	a.addFirst(1);
	System.out.println(a.removeFirst());
	System.out.println(a);
	System.out.println(a.removeLast());
	System.out.println(a);
	System.out.println(a.getFirst());
	System.out.println(a.getLast());
	System.out.println(a);
    }
    
    public MyDoubleEndedQueue() {
	data = new Object[10];
	head = 4;
	tail = 3;
	size = 0;
    }
    public String toString() {
	String toReturn = "";
	toReturn += "Head: ";
	toReturn += ("" + head);
	toReturn += "\nTail: " + ("" + tail);
	toReturn += "\n[";
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
	if (tail < 0) {
	    data[data.length + tail--] = value;
	}
	else {
	    data[tail--] = value;
	}
	size++;
    }
    public void addLast(T value) {
	if (isFull()) {
	    getAndResize();
	}
	data[head++ % data.length] = value;
	size++;
    }
    public T removeFirst() {
	T a = (T)data[tail];
	data[tail++] = null;
	size--;
	return a;
    }
    public T removeLast() {
	T a = (T)data[head];
	data[head--] = null;
	size--;
	return a;
    }   
    public T getFirst() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	return (T)data[tail];
    }
    public T getLast() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	return (T)data[head];
    }
	
    public void getAndResize() {
	Object[] hi = new Object[data.length * 2];
	int i = tail;
	while (i != head) {
	
	}
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
