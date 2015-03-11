public class LinkedList {
    public static void main(String[] args) {
	LinkedList a = new LinkedList();
	a.add(2);
	System.out.println(a);
	a.add(3);
	System.out.println(a);
	a.add(4);
	System.out.println(a);
	System.out.println(a.size());
    }
    private LNode node;
    public LinkedList() {}
    public String toString() {
	LNode checking = node;
	String toReturn = "{";
	if (checking != null) {
	    toReturn += (checking.car() + " ");
	    while (checking.cdr() != null) {
		checking = checking.cdr();
		toReturn += (checking.car() + " ");
	    }
	}
	toReturn += "}";
	return toReturn;
    }
    public int get(int index) {
	return -1;
    }
    public void set (int index, int value) {
	
    }
    public void add(int value) {
	if (size() == 0) {
	    node = new LNode(value);
	}
	else {
	    LNode temp = node;
	    for (int i = 0; i < size(); i++) {
		temp = temp.cdr();
	    }
	    if (size() == 1) {
		temp = node;
	    }
	    LNode newNode = new LNode(value);
	    temp.setCdr(newNode);
	}
    }
    public void add(int value, int index) {

    }
    public void remove(int index) {

    }
    public int size() {
	int size = 0;
	if (node != null) {
	    size++;
	    LNode checking = node;
	    while (checking.cdr() != null) {
		size++;
	    }
	}
	return size;
    }
    public int indexOf(int value) {
	return -1;
    }
}