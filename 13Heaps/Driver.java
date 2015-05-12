import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
	Scanner console = new Scanner(System.in);
	MyHeapGenerics<Integer> a = new MyHeapGenerics(true);
	a.add(1);
	System.out.println(a);
	a.add(4);
	System.out.println(a);
	a.add(6);
	System.out.println(a);

	while(!console.next().equals("quit")) {
	    if (console.next().equals("add")) {
		a.add(Integer.parseInt(console.next()));
		System.out.println(a);
	    }
	    else if (console.next().equals("remove")) {
		a.remove();
		System.out.println(a);
	    }
	}
    }
}