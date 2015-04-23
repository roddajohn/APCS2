public class BTree<T> {
    private TreeNode<T> root;
    public BTree() {}

    public String toString() {
	String toReturn = "";
	toReturn += toString(root);
	return toReturn;
    }
    
    public String toString(TreeNode<T> checking) {
	String toReturn = "";
	if (checking.getLeft() == null) {
	    toReturn += " ";
	}
	else {
	    toReturn += toString(checking.getLeft());
	}
	toReturn += checking.getData().toString();
	if (checking.getRight() == null) {
	    toReturn += " ";
	}
	else {
	    toReturn += toString(checking.getRight());
	}
	return toReturn;
    }
    public T add(T newData) {
	if (root == null) {
	    root = new TreeNode<T> (newData);
	}
	else {
	    return addL(newData, root);
	}
	return newData;
    }

    public T addL(T newData, TreeNode<T> checking) {
	if (checking.getLeft() == null) {
	    checking.setLeft(new TreeNode<T>(newData));
	}
	else if (checking.getRight() == null) {
	    checking.setRight(new TreeNode<T>(newData));
	}
	else {
	    addL(newData, checking.getLeft());
	}
	return newData;
    }
}