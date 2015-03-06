public class QuickSelect {
    public static void main(String[] args) {
	int[] toPass = {4, 7, 6, 1, 2, 3, 4};
	int[] toReturn = partition(toPass, 0, 4);
	printArr(toReturn);
    }
    public static void printArr (int[] toReturn) {
	System.out.print("[");
	for (int i = 0; i < toReturn.length; i++) {
	    System.out.print(toReturn[i] + " ");
	}
	System.out.println("]");
    }
    public static int[] partition(int[] array, int start, int end) {
	int originalEnd = end;
	int[] l = new int[array.length];
	for (int i = 0; i < start; i++) {
	    l[i] = array[i];
	}
	int pivotValue = array[start];
	for (int i = start + 1; i < originalEnd + 1; i++) {
	    if (array[i] < pivotValue) {
		l[start++] = array[i];
	    }
	    else {
		l[end--] = array[i];
	    }
	}
	l[start] = pivotValue;
	for (int i = originalEnd; i + 1 < array.length; i++) {
	    l[i + 1] = array[i + 1];
	}
	return l;
    }
}