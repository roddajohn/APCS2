public class MyHeap {
    private MyHeapGenerics<Integer> heap;
    public MyHeap(boolean a) {
	heap = new MyHeapGenerics(a);
    }

    public MyHeap() {
	heap = new MyHeapGenerics();
    }

    public String toString() {
	return heap.toString();
    }

    public int remove() {
	return heap.remove();
    }

    public void add(int a) {
	heap.add(a);
    }

    public int peek() {
	return heap.peek();
    }
}