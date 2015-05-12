import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
	Scanner console = new Scanner(System.in);
	MyHeap a = new MyHeap(false);
	String input = "";
	while(!input.equals("quit")) {
	    input = console.next();
	    if (input.equals("add")) {
		a.add(Integer.parseInt(console.next()));
		System.out.println(a);
	    }
	    else if (input.equals("remove")) {
		a.remove();
		System.out.println(a);
	    }
	}
    }
}