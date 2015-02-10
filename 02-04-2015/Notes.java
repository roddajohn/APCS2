public class Notes {
    public static void main(String[]args) {

    }

    public static int foo(int n) {
	if (n > 0) {
	    return 1 + foo(n - 1);
	}
	else {
	    return 0;
	}
    }
}