public class TreeNode<T> {
    private T data;
    private TreeNode<T> left, right;
    public TreeNode(T newData) {
	data = newData;
    }
    public void setData(T newData) {
	data = newData;
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
}