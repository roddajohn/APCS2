import java.util.ArrayList;

public class MyHeapGenerics<T extends Comparable> {
    private ArrayList<T> data;
    private boolean isMax;
    public MyHeapGenerics(boolean isMaxa) {
	data = new ArrayList<T>();
	isMax = isMaxa;
    }
    public MyHeapGenerics() {
	data = new ArrayList<T>();
	isMax = true;
    }

    public T peek() {
	try {
	    return data.get(0);
	}
	catch (IndexOutOfBoundsException e) {
	    return null;
	}
    }

    public boolean compare(int index, int index1) {
	if (index >= data.size() || index < 0 || index1 >= data.size() || index1 < 0) {
	    if (index < index1) {
		return true;
	    }
	    
	}
	if (isMax) {
	    if (data.get(index).compareTo(data.get(index1)) >= 0) {
		return true;
	    }
	}
	else {
	    if (data.get(index).compareTo(data.get(index1)) < 0) {
		return true;
	    }
	}
	return false;
    }

    public T add(T value) {
	data.add(value);
	moveUp(data.size() - 1);
	return value;
    } 

    public T remove() {
	swap(0, data.size() - 1);
	T toReturn = data.remove(data.size() - 1);
	moveDown(0);
	return toReturn;
    }

    private void moveDown(int index) {
	while (index < data.size() && (!compare(index, getLeftChild(index)) || !compare(index, getRightChild(index)))) {
	    if (compare(getLeftChild(index), getRightChild(index))) {
		swap(index, getLeftChild(index));
		index = getLeftChild(index);
	    }
	    else {
		swap(index, getRightChild(index));
		index = getRightChild(index);
	    }	
	}
    }

    private void moveUp(int index) {
	while (index != 0 && compare(index, getParent(index))) {
	    swap(index, getParent(index));
	    index = getParent(index);
	}
    }

    private void swap(int index, int index1) {
	T temp = data.get(index);
	data.set(index, data.get(index1));
	data.set(index1, temp);
    }

    private int getParent(int index) {
	return (int) ((index - 1) / 2);
    }

    private int getLeftChild(int index) {
	return (int) ((index * 2 + 1));
    }

    private int getRightChild(int index) {
	return (int) ((index * 2 + 2));
    }

    public String toString() {
	String toReturn = "";
	for (int i = 0; i < data.size(); i++) {
	    toReturn += data.get(i).toString() + " ";
	}
	return toReturn;
    }
}