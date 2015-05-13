aimport java.util.ArrayList;

public class RunningMedian {
    private MyHeap maxHeap;
    private MyHeap minHeap;
    private ArrayList<Integer> middle;
    private int sizeOfHeaps;

    public RunningMedian() {
	maxHeap = new MyHeap(true);
	minHeap = new MyHeap(false);
	middle = new ArrayList<Integer>();
    }

    public void add(int n) {
	if (middle.size() == 0) {
	    middle.add(n);
	}
	else if (middle.size() == 1) {
	    if (sizeOfHeaps > 0) {
		if (n < middle.get(0) && n > maxHeap.peek()) {
		    
		}
	       
	    }
	}
	else if (middle.size() == 2) {

	}
    }

    public double getMedian() {
	if (middle.size() == 1) {
	    return middle.get(0);
	}
	else if (middle.size() == 2) {
	    return (middle.get(0) + middle.get(1)) / 2;
	}
	return -1;
    }

    public String toString() {
	String toReturn = "";
	toReturn += "Left Max Heap: " + maxHeap.toString();
	toReturn += "\nRight Min Heap: " + minHeap.toString();
	toReturn += "\nMiddle: " + middle.toString();
	return toReturn;
    }
}