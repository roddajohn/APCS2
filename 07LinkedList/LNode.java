public class LNode {
    private int o;
    private LNode n;
    
    public LNode(int object, LNode nextNode) {
	o = object;
	n = nextNode;
    }
    public LNode() {}
    public LNode(int object) {
	o = object;
    }

    public int car() {
	return o;
    }
    public LNode cdr() {
	return n;
    }
    public void setCar(int object) {
	o = object;
    }
    public void setCdr(LNode nextNode) {
	n = nextNode;
    }
    public String toString() {
	return "" + o;
    }
}