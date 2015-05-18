import java.util.Random;

public class Driver {
    public static void main(String[] args) {
	Random random = new Random();
	int[] array = new int[100];
	for (int i = 0; i < array.length; i++) {
	    array[i] = random.nextInt(10000);
	}
	Heapsort.heapsort(array);
	for (int i = 0; i < array.length; i++) {
	    System.out.print(array[i] + ", ");
	}
	System.out.println();
    }
}