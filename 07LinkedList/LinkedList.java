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
	System.out.println(a.get(2));
	a.set(0, 5);
	System.out.println(a);
	a.add(6, 0);
	System.out.println(a);
	a.remove(1);
	System.out.println(a);
	System.out.println(a.indexOf(3));
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
	LNode checking = node;
	for (int i = 0; i < index; i++) {
	    if (checking == null) {
		throw new IndexOutOfBoundsException();
	    }
	    else {
		checking = checking.cdr();
	    }
	}
	return checking.car();
    }
    public void set (int index, int value) {
	LNode checking = node;
	for (int i = 0; i < index; i++) {
	    if (checking == null) {
		throw new IndexOutOfBoundsException();
	    }
	    else {
		checking = checking.cdr();
	    }
	}
	checking.setCar(value);
    }
    public void add(int value) {
	if (size() == 0) {
	    node = new LNode(value);
	}
	else {
	    LNode temp = node;
	    if (size() == 1) {
		temp = node;
	    }
	    else {
		for (int i = 1; i < size(); i++) {
		    temp = temp.cdr();
		}
	    }
	    
	    LNode newNode = new LNode(value);
	    temp.setCdr(newNode);
	}
    }
    public void add(int value, int index) {
	LNode checking = node;
	for (int i = 0; i < (index - 1); i++) {
	    if (checking == null) {
		throw new IndexOutOfBoundsException();
	    }
	    else {
		checking = checking.cdr();
	    }
	}
	if (index == 0) {
	    LNode newNode = new LNode(value, node);
	    node = newNode;
	}
	else {
	    LNode newNode = new LNode(value, checking.cdr());
	    checking.setCdr(newNode);
	}
    }
    public void remove(int index) {
	LNode checking = node;
	for (int i = 0; i < (index - 1); i++) {
	    if (checking == null) {
		throw new IndexOutOfBoundsException();
	    }
	    else {
		checking = checking.cdr();
	    }
	}
	if (index == 0) {
	    node = node.cdr();
	}
	else {
	    checking.setCdr(checking.cdr().cdr());
	}
    }
    public int size() {
	int size = 0;
	if (node != null) {
	    size++;
	    LNode checking = node;
	    while (checking.cdr() != null) {
		size++;
		checking = checking.cdr();
	    }
	}
	return size;
    }
    public int indexOf(int value) {
	LNode checking = node;
	int i = 0;
	while(checking.car() != value) {
	    i++;
	    checking = checking.cdr();
	    if (checking == null) {
		i = -1;
		break;
	    }
	}
	return i;
    }
}