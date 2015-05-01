public class TreeNode<T extends Comparable> {
    private T data;
    private int tally;
    private TreeNode<T> left, right;
    public TreeNode(T newData) {
	data = newData;
	tally = 1;
    }
    public void setData(T newData) {
	data = newData;
    }
    public void incrementTally() {
	tally++;
    }
    public void decrementTally() {
	tally--;
    }
    public void setLeft(TreeNode<T> newLeft) {
	left = newLeft;
    }
    public void setRight(TreeNode<T> newRight) {
	right = newRight;
    }
    public T getData() {
	return data;
    }
    public TreeNode<T> getLeft() {
	return left;
    }
    public TreeNode<T> getRight() {
	return right;
    }
    public int getTally() {
	return tally;
    }
    public String toString() {
	return "" + data.toString() + " (" + tally + ")";
    }
}