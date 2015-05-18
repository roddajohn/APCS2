public class Heapsort {
    public static void heapsort(int[] array) {
	heapify(array);
	sorted(array);
    }

    public static void heapify(int[] array) {
	for (int i = array.length - 1; i > -1; i--) {
	    if (array[i] > array[getParent(i)]) {
		swap(array, i, getParent(i));
	    }
	}
    }

    public static void sorted(int[] array) {
	for (int i = 0; i < array.length; i++) {
	    swap(array, 0, array.length - (i + 1));
	    moveDown(array, 0, array.length - (i + 1));
	    System.out.println();
	    System.out.print("In sorted: ");
	    for (int j = 0; j < array.length; j++) {
		System.out.print(array[j] + ", ");
	    }
	    System.out.println();
	}
    }
    
    public static int getParent(int n) {
	return (n - 1) / 2;
    }

    public static int getLeftChild(int n) {
	return (2 * n) + 1;
    }

    public static int getRightChild(int n) {
	return (2 * n) + 2;
    } 

    public static void swap(int[] array, int a, int b) {
	int temp = array[a];
	array[a] = array[b];
	array[b] = temp;
    }

    public static void moveDown(int[] array, int n, int end) {
	System.out.println();
	while ((getLeftChild(n) < end || getRightChild(n) < end) && (array[n] < array[getLeftChild(n) || array[n] < array[getRightChild(n)]))) {
	    System.out.println("In move down: ");
	    for(int i = 0; i < array.length; i++) {
		System.out.print(array[i] + ", ");
	    }
	    if (getLeftChild(n) < end && getRightChild(n) < end && (array[n] < array[getLeftChild(n)] && array[n] < array[getRightChild(n)])) {
		if (array[getLeftChild(n)] < array[getRightChild(n)]) {
		    swap(array, n, getRightChild(n));
		    n = getRightChild(n);
		}
		else {
		    swap(array, n, getLeftChild(n));
		    n = getLeftChild(n);
		}
	    }
	    else if (getLeftChild(n) < end && array[n] < array[getLeftChild(n)]) {
		swap(array, n, getLeftChild(n));
		n = getLeftChild(n);
	    }
	    else if (getRightChild(n) < end && array[n] < array[getRightChild(n)]) {
		swap(array, n, getRightChild(n));
		n = getRightChild(n);
	    }
	}
    }

    public static void moveUp(int n) {

    }
}