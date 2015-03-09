public class QuickSelect {
    public static void main(String[] args) {
	int[] toPass = {-50, -100, 6, 1, 2, 3, 4, -100, -20};
        quickSelect(toPass, 0, toPass.length - 1, 4);
    }
    public static void printArr (int[] toReturn) {
	System.out.print("[");
	for (int i = 0; i < toReturn.length; i++) {
	    System.out.print(toReturn[i] + " ");
	}
	System.out.println("]");
    }
    public static void partition(int[] array, int start, int end) {
	int[] l = new int[array.length];
	for (int i = 0; i < array.length; i++) {
	    if (i < start || i > end) {
		l[i] = array[i];
	    }
	}
	int pivot = start + (int) (Math.random() * (end - start + 1));
	int value = array[pivot];
	int ei = end;
	System.out.println("Pivot: " + value);
	for (int i = start; i <= ei; i++) {
	    printArr(l);
	    if (i != pivot) {
		if (array[i] < value) {
		    l[start++] = array[i];
		}
		else {
		    l[end--] = array[i];
		}
	    }
	}
	l[start] = value;
	printArr(l);
    }

    public static void swap(int[] array, int i, int j) {
	int temp = array[i];
	array[i] = array[j];
	array[j] = temp;
    }


    public static void quickSelect(int[] array, int start, int end, int n) {
	int[] l = new int[array.length];
	for (int i = 0; i < array.length; i++) {
	    if (i < start || i > end) {
		l[i] = array[i];
	    }
	}
	int pivot = start + (int) (Math.random() * (end - start + 1));
	int value = array[pivot];
	int ei = end;
	int si = start;
	System.out.println("Pivot: " + value);
	for (int i = start; i <= ei; i++) {
	    printArr(l);
	    if (i != pivot) {
		if (array[i] < value) {
		    l[start++] = array[i];
		}
		else {
		    l[end--] = array[i];
		}
	    }
	}
	l[start] = value;
	printArr(l);
	if (start == n - 1) {
	    System.out.println(l[start]);
	}
	else if (n - 1 < start) {
	    quickSelect(l, si, start - 1, n);
	}
	else {
	    quickSelect(l, start + 1, ei, n);
	}
    }
}