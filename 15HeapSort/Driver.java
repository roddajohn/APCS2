public class Driver {
    public static void main(String[] args) {
	int[] array = {4, 7, 2, 8, 1, 9, 3};
	Heapsort.heapify(array);
	for (int i = 0; i < array.length; i++) {
	    System.out.print(array[i] + ", ");
	}
	System.out.println();
	Heapsort.sorted(array);
	for (int i = 0; i < array.length; i++) {
	    System.out.print(array[i] + ", ");
	}
	System.out.println();
    }
}