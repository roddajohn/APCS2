public class MyLinkedList<T> {
    public static void main(String[] args) {
	MyLinkedList<String> a = new MyLinkedList<String>();
	a.add("Hi");
	a.add("I");
	a.add("J");
	a.add("K");
	a.remove(3);
	a.add("L");
	System.out.println(a);
	System.out.println(a.size());
    }

    public String name() {
	return "john.rodda";
    }

    private LNode<T> node;
    private LNode<T> endNode;
    private int size;
    public MyLinkedList() {
	node = new LNode<T>();
	size = 0;
	endNode = node;
    }
    public String toString() {
	LNode<T> checking = node.cdr();
	String toReturn = "[";
	if (checking != null) {
	    toReturn += (checking.car() + "");
	    while (checking.cdr() != null) {
		checking = checking.cdr();
		toReturn += (", " + checking.car());
	    }
	}
	toReturn += "]";
	return toReturn;
    }
    public T get(int index) {
	LNode<T> checking = node.cdr();
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
    public void set (int index, T value) {
	if (index < 0) {
	    throw new IndexOutOfBoundsException();
	}
	LNode<T> checking = node;
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
    public void add(T value) {
 	LNode<T> newNode = new LNode<T>(value);
 	endNode.setCdr(newNode);
 	endNode = newNode;
 	size++;
    }
    public void add(T value, int index) { 
 	if (index < 0) {
 	    throw new IndexOutOfBoundsException();
 	}
	LNode<T> checking = node.cdr();
	for (int i = 0; i < (index - 1); i++) {
	    if (checking == null) {
		throw new IndexOutOfBoundsException();
	    }
	    else {
		checking = checking.cdr();
	    }
	}
	size++;
	if (index == 0) {
	    LNode<T> newNode = new LNode<T>(value, node);
	    node = newNode;
	}
	else {
	    LNode<T> newNode = new LNode<T>(value, checking.cdr());
	    checking.setCdr(newNode);
	}
    }
    public void remove(int index) {
	if (index < 0) {
	    throw new IndexOutOfBoundsException();
	}
	LNode<T> checking = node.cdr();
	for (int i = 0; i < (index - 1); i++) {
	    if (checking == null) {
		throw new IndexOutOfBoundsException();
	    }
	    else {
		checking = checking.cdr();
	    }
	}
	size--;
	if (index == 0) {
	    node = node.cdr();
	}
	else {
	    if (checking.cdr() == endNode) {
		endNode = checking;
	    }
	    checking.setCdr(checking.cdr().cdr());
	}
    }
    public int size() {
	return size;
    }
    public int indexOf(T value) {
	LNode<T> checking = node.cdr();
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