

public class MergeSort {
    public static void main(String[] args) {
	
	int[] a = {1, 3, 6, 7, 9, 10};
	int[] b = {2, 4, 5, 8, 11};
	int[] hi = merge(a, b);
	for (int i = 0; i < hi.length; i++) {
	    System.out.println(hi[i]);
	}

    }

    public static int[] merge(int[] a, int[] b) {
	int[] newArray = new int[a.length + b.length];
	int indexToAdd = 0;
	int j = 0;
	for (int i = 0; i < a.length; i++) {
	    for (; j < b.length; j++) {
		if (a[i] < b[j]) {
		    newArray[indexToAdd] = a[i];
		    indexToAdd++;
		    break;
		}
		else if (b[j] < a[i]) {
		    newArray[indexToAdd] = b[j];
		    indexToAdd++;
		    break;
		}
		else {
		    newArray[indexToAdd] = a[i];
		    indexToAdd++;
		    break;
		}
	    }
	}
	return newArray;
    }
}