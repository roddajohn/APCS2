public class Classnotes {
    public static void main(String[] args) {
	
    }
    public static int sumofdigits(int n) {
	if (n < 1) {
	    return 0;
	}
	return (n % 10) + sumofdigits(n / 10);
    }
    public static int sumofdigitshelper(int n, int ans) {
	if (n < 1) {
	    return ans;
	}
	return sumofdigitshelper(n / 10, ans + n % 10);
    }
    public static int sumofdigitstailrecursion(int n) {
	return sumofdigitshelper(n, 0);
    }
}