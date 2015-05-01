import java.lang.Math;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
	BSTree<Integer> hi = new BSTree<Integer>();
	String input = "";
	Scanner console = new Scanner(System.in);
	while (!input.equals("quit")) {
	    input = console.next();
	    if (input.equals("remove")) {
	        int number = Integer.parseInt(console.next());
		hi.remove(number);
	    }
	    else if (input.equals("add")) {
		int number = Integer.parseInt(console.next());
		hi.add(number);
	    }
	    System.out.println(hi);
	}
    }
}