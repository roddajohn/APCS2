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
	//	for (int i = 0; i < 100; i++) {
	//    a.addLast(1);
	//    System.out.println(a);
	//}
    }
    
    public MyDoubleEndedQueue() {
	data = new Object[10];
	head = 5;
	tail = 4;
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
	data[tail--] = value;
	if (tail == -1) {
	    tail = data.length - 1;
	}
    }
    public void addLast(T value) {
	if (isFull()) {
	    getAndResize();
	}
	data[head++] = value;
	if (head == data.length) {
	    head = 0;
	}
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
	int j = 0;
	while (i != head) {
	    //	    System.out.println(i + " is i");
	    //      System.out.println(head + " is head");
	    if (i < 0) {
		hi[j++] = data[data.length + i++];
	    }
	    else {
		if (i == 0) {
		    hi[j++] = data[i++];
		}
		else {
		    //System.out.println("J = " + j);
		    //System.out.println(data.length % i + " schtuff");
		    hi[j++] = data[i++ % data.length];
		}
	    }
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
