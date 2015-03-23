public class MyQueue<T> extends MyLinkedList<T> {
    public static void main(String[] args) {
	MyQueue<Integer> a = new MyQueue<Integer>();
	a.enqueue(1);
	a.enqueue(2);
	a.enqueue(3);
	System.out.println(a.dequeue());
	System.out.println(a.dequeue());
    }

    public void enqueue(T n) {
	add(n);
    }

    public T dequeue() {
	T toReturn = get(0);
	remove(0);
	return toReturn;
    }
}