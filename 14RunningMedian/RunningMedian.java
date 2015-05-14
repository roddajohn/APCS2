import java.util.ArrayList;

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
	    if (n < middle.get(0) && n > maxHeap.peek()) {
		middle.add(middle.get(0));
		middle.set(0, n);
	    }
	    else if (n <= maxHeap.peek()) {
		middle.add(middle.get(0));
		middle.set(0, maxHeap.remove());
		maxHeap.add(n);
	    }
	    else if (n > middle.get(0) && n < minHeap.peek()) {
		middle.add(n);
	    }
	    else if (n >= minHeap.peek()) {
		middle.add(minHeap.remove());
		minHeap.add(n);
	    }
	    else {
		middle.add(n);
	    }
	}
	else if (middle.size() == 2) {
	    if (n <= middle.get(0) && n > maxHeap.peek()) {
		maxHeap.add(middle.get(1));
		minHeap.add(n);
		middle.remove(1);
	    }
	    else if (n <= maxHeap.peek()) {
		maxHeap.add(n);
		minHeap.add(middle.get(1));
		middle.remove(1);
	    }
	    else if (n >= middle.get(0) && n < minHeap.peek()) {
		minHeap.add(n);
		maxHeap.add(middle.get(0));
		middle.remove(0);
	    }
	    else if (n >= minHeap.peek()) {
		minHeap.add(n);
		maxHeap.add(middle.get(0));
		middle.remove(0);
	    }
	    else if (n > middle.get(0) && n < middle.get(1)) {
		maxHeap.add(middle.get(0));
		minHeap.add(middle.get(1));
		middle.set(0, n);
		middle.remove(1);
	    }
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