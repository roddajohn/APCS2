public class LNode<T> {
    private T o;
    private LNode n;
    
    public LNode(T object, LNode nextNode) {
	o = object;
	n = nextNode;
    }
    public LNode() {}
    public LNode(T object) {
	o = object;
    }

    public T car() {
	return o;
    }
    public LNode<T> cdr() {
	return n;
    }
    public void setCar(T object) {
	o = object;
    }
    public void setCdr(LNode<T> nextNode) {
	n = nextNode;
    }
    public String toString() {
	return "" + o;
    }
}