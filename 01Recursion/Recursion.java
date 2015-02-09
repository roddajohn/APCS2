public class Recursion {
    public String name() {
	return "John,Rodda";
    }
    public int fact(int n) {
	if (n < 0) {
	    throw new IllegalArgumentException();
	}
	else if (n == 0) {
	    return 1;
	}
	else {
	    return n * fact (n - 1);
	}
    }
    public int fib (int n) {
	//if (n == 0) {return 0;}
	return fibHelper(0, 0, 1, n);
    }
    public int fibHelper(int n, int a, int b, int target) {
	if (n < 0) {throw new IllegalArgumentException();}
	if (n == target) {return a;}
	else {
	    return fibHelper(n + 1, b, a + b, target);
	}
    }
    public double sqrt(double n) {
	if (n < 0) {
	    throw new IllegalArgumentException();
	}
	return sqrtHelper(n, n / 2);
    }
    public double sqrtHelper(double n, double guess) {
	if (Math.abs((guess * guess) - n) < .0000000005) {
	    return guess;
	}
	else {
	    return sqrtHelper(n, (n / guess + guess) / 2);
	}
    }
    public static void main(String[]args) {
	Recursion r = new Recursion();
	//System.out.println(r.fact(1));
	//System.out.println(r.fact(2));
	//System.out.println(r.fact(3));
	System.out.println(r.fib(0));
	System.out.println(r.fib(1));
	System.out.println(r.fib(8));
	//System.out.println(r.sqrt(100));
	//System.out.println(r.sqrt(49));
    }
}