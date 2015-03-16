public class Sorts {
     
    private int[] array;
    private int[] tempMergArr;
    private int length;

    public static String name() {
	return "john.rodda";
    }
 
    public static void main(String a[]){
	int[] toSort = {3, 4, 6, 2, 4, 8, 4, 6, 5, 3};
	toSort = sort(toSort);
	for (int i = 0; i < toSort.length; i++) {
	    System.out.println(" " + toSort[i] + " ");
	}

    }
     
    public static int[] sort(int inputArr[]) {
        int[] array = inputArr;
        int length = inputArr.length;
        int[] tempMergArr = new int[length];
        doMergeSort(array, length, tempMergArr, 0, length - 1);
	return array;
    }
    
    
    private static int[] doMergeSort(int[] array, int length, int[] tempMergArr, int lowerIndex, int higherIndex) {
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            doMergeSort(array, length, tempMergArr, lowerIndex, middle);
            // Below step sorts the right side of the array
            doMergeSort(array, length, tempMergArr, middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(array, length, tempMergArr, lowerIndex, middle, higherIndex);
        }
	return array;
    }
 
    private static int[] mergeParts(int[] array, int length, int[] tempMergArr, int lowerIndex, int middle, int higherIndex) {
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }
	return array;
    }
}