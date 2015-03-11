public class Node {
    private int o;
    private Node n;
    
    public Node(int object, Node nextNode) {
	o = object;
	n = nextNode;
    }
    public Node() {}
    public Node(int object) {
	o = object;
    }

    public int get() {
	return o;
    }
    public Node cdr() {
	return n;
    }
    public void setCar(int object) {
	o = object;
    }
    public void setCdr(Node nextNode) {
	n = nextNode;
    }
    public String toString() {
	return "" + o;
    }
}