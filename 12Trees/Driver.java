public class Driver {
    public static void main(String[] args) {
	BTree<Integer> hi = new BTree<Integer>();
	for (int i = 0; i < Integer.parseInt(args[0]); i++) {
	    hi.add(i);
	    System.out.println(hi);
	}
    }
}