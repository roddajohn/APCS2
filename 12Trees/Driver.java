import java.lang.Math;

public class Driver {
    public static void main(String[] args) {
	BSTree<Integer> hi = new BSTree<Integer>();
	for (int i = 0; i < Integer.parseInt(args[0]); i++) {
	    hi.add((int) (Math.random() * 10));
	}
	System.out.println(hi);
    }
}