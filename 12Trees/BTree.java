import java.lang.Math;

public class BTree<T> {
    private TreeNode<T> root;
    public static final int PRE_ORDER = 0;
    public static final int IN_ORDER = 1;
    public static final int POST_ORDER = 2;
    public BTree() {}

    public String traverse(int mode) {
	String toReturn = "";
	if (mode == PRE_ORDER) {
	    toReturn += preOrder(root);
	}
	else if (mode == IN_ORDER) {
	    toReturn += inOrder(root);
	}
	else if (mode == POST_ORDER) {
	    toReturn += postOrder(root);
	}
	else {
	    toReturn += "ERROR -- INVALID MODE";
	}
	return toReturn;
    }
    
    private String inOrder(TreeNode<T> checking) {
	String toReturn = "";
	if (checking.getLeft() == null) {
	    toReturn += " ";
	}
	else {
	    toReturn += inOrder(checking.getLeft());
	}
	toReturn += checking.getData().toString() + " ";
	if (checking.getRight() == null) {
	    toReturn += " ";
	}
	else {
	    toReturn += inOrder(checking.getRight());
	}
	return toReturn;
    }

    private String preOrder(TreeNode<T> checking) {
	String toReturn = "";
	toReturn += checking.getData().toString() + " ";
	if (checking.getLeft() == null) {
	    toReturn += " ";
	}
	else {
	    toReturn += preOrder(checking.getLeft());
	}
	if (checking.getRight() == null) {
	    toReturn += " ";
	}
	else {
	    toReturn += preOrder(checking.getRight());
	}
	return toReturn;
    }

    private String postOrder(TreeNode<T> checking) {
	String toReturn = "";
	if (checking.getLeft() == null) {
	    toReturn += " ";
	}
	else {
	    toReturn += postOrder(checking.getLeft());
	}
	if (checking.getRight() == null) {
	    toReturn += " ";
	}
	else {
	    toReturn += postOrder(checking.getRight());
	}
	toReturn += checking.getData().toString() + " ";
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

    private T addL(T newData, TreeNode<T> checking) {
	if (((int) Math.floor(Math.random() * 101) % 2) == 0) {
	    if (checking.getLeft() == null) {
		checking.setLeft(new TreeNode<T>(newData));
	    }
	    else if (checking.getRight() == null) {
		checking.setRight(new TreeNode<T>(newData));
	    }
	    else {
		if (((int) Math.floor(Math.random() * 101) % 2) == 0) {
		    addL(newData, checking.getRight());
		}
		else {
		    addL(newData, checking.getLeft());
		}
	    }
	}
	else {
	    if (checking.getRight() == null) {
		checking.setRight(new TreeNode<T>(newData));
	    }
	    else if (checking.getLeft() == null) {
		checking.setLeft(new TreeNode<T>(newData));
	    }
	    else {
		if (((int) Math.floor(Math.random() * 101) % 2) == 0) {
		    addL(newData, checking.getRight());
		}
		else {
		    addL(newData, checking.getLeft());
		}
	    }
	}
	return newData;
    }

    public int getHeight() {
	return getHeight(root);
    }

    private int getHeight(TreeNode<T> checking) {
	int heightLeft = 1;
	if (checking.getLeft() != null) {
	    heightLeft = heightLeft + getHeight(checking.getLeft());
	}
	int heightRight = 1;
	if (checking.getRight() != null) {
	    heightRight = heightRight + getHeight(checking.getRight());
	}
	if (heightLeft > heightRight) {
	    return heightLeft;
	}
	else {
	    return heightRight;
	}
    }

    private String getLevel(TreeNode<T> checking, int level, int currLevel) {
	String toReturn = "";
	int height = getHeight();

	// Basically if n = amount of levels below it, space between things have to be (n * 4) + 1
       	if (level == currLevel) {
	    return checking.getData().toString();
	}
	else if (checking.getLeft() != null) {
	    toReturn += getLevel(checking.getLeft(), level, currLevel + 1) + " ";
	}
	if (checking.getRight() != null && level != currLevel) {
	    toReturn += getLevel(checking.getRight(), level, currLevel + 1) + " ";
	}
	else {
	    toReturn += "   ";
	}
	return toReturn;
    }

    public String toString() {
	String toReturn = "";
	for (int i = 0; i < getHeight(root); i++) {
	    toReturn += getLevel(root, i, 0) + "\n";
	}
	return toReturn;
    }
}