public class MyStack<T> extends MyLinkedList<T> {
    public static void main(String[] args) {
	MyStack<Integer> stack = new MyStack<Integer>();
	stack.push(1);
	stack.push(2);
	stack.push(3);
	System.out.println(stack.pop());
	System.out.println(stack);
    }
    public String name() {
	return "john.rodda";
    }
    public MyStack() {
	super();
    }
    public T push(T o) {
	this.add(o, 0);
	return o;
    }
    public T pop() {
	T o = this.get(0);
	this.remove(0);
	return o;
    }
    public T peek() {
	return this.get(0);
    }
}