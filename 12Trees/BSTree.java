import java.io.*;
import java.util.*;

public class BSTree <T extends Comparable> {

    private TreeNode<T> root;

    public BSTree() {
	root = null;
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

    public boolean isEmpty() {
	return root == null;
    }
    public boolean isLeaf(TreeNode<T> t) {
	return (t.getLeft() == null && t.getRight() == null);
    }
    public int children(TreeNode<T> t) {
	if (t.getLeft() == null && t.getRight() == null) {
	    return 0;
	}
	else if (t.getLeft() != null && t.getRight() != null) {
	    return 2;
	}
	else {
	    return 1;
	}
    }

    /*======== public void add() ==========
      Inputs:   T c  
      Returns: 

      Wrapper for the recursive add method
      ====================*/
    public void add(T c) {
	root = add(root, new TreeNode<T>(c));
    }

    /*======== public BSTreeNode<T> add() ==========
      Inputs:  BSTreeNode<T> curr
               BSTreeNode<T> t 
      Returns: 

      Add t to the correct place in the tree rooted at curr.
      ====================*/
    private TreeNode<T> add(TreeNode<T> curr, TreeNode<T> t) {
	if (curr == null) {
	    return t;
	}
	else if (t.getData().compareTo(curr.getData()) < 0) {
	    curr.setLeft(add(curr.getLeft(), t));
	    return curr;
	}
	else if (t.getData().compareTo(curr.getData()) == 0) {
	    curr.incrementTally();
	    return curr;
	}
	else {
	    curr.setRight(add(curr.getRight(), t));
	    return curr;
	}
    }

    /*======== public void remove() ==========
      Inputs:   T c  
      Returns: 
      
      Wrapper for the recursive remove method
      ====================*/
    public void remove(T c) {
	root = remove(root, c);
    }

    /*======== public BSTreeNode<T> remove() ==========
      Inputs:   BSTreeNode<T> curr
      T c
      Returns: 

      Should remove the value c from the tree rooted at
      curr, if it exists.
      ====================*/
    private TreeNode<T> remove(TreeNode<T> curr, T c) {
	if (curr.getLeft() != null && curr.getLeft().getData().compareTo(c) == 0) {
	    if (curr.getLeft().getTally() > 1) {
		curr.getLeft().decrementTally();
	    }
	    else if (children(curr.getLeft()) == 0) {
		curr.setLeft() = null;
	    }
	    else if (children(curr.getLeft()) == 1) {
		if (curr.getLeft().getLeft() == null) {
		    curr.setLeft(curr.getLeft().getRight());
		}
		else {
		    curr.setLeft(curr.getLeft().getLeft());
		}
	    }
	    else {

	    }
	}
	else if (curr.getRight() != null && curr.getRight().getData().compareTo(c) == 0) {
	    if (curr.getRight().getTally() > 1) {
		curr.getRight().decrementTally();
	    }
	    else if (children(curr.getRight()) == 0) {
		curr.getRight() = null;
	    }
	    else if (children(curr.getRight()) == 1) {
		if (curr.getRight().getLeft() == null) {
		    curr.setRight(curr.getRight().getRight());
		}
		else {
		    curr.setRight(curr.getRight().getLeft());
		}
	    }
	    else {
		
	    }
	}
	else if (curr.getData().compareTo(c) > 0) {
	    remove(curr.getLeft(), c);
	}
	else {
	    remove(curr.getRight(), c);
	}
	return curr;
    }


    /*======== public void inOrder()) ==========
      Inputs:   
      Returns: 

      Wrapper for the recursive inOrder method
      ====================*/
    public void inOrder() {
	inOrderHelper(root);
	System.out.println();
    }

    /*======== public void inOrderHelper() ==========
      Inputs:   BSTreeNode<T> t  
      Returns: 
      
      Performs an in-order traversal for the tree with 
      root t.
      ====================*/
    public void inOrderHelper(TreeNode<T> t) {
	if (t == null) 
	    return;
	inOrderHelper(t.getLeft() );
	System.out.print(t.getData() + " ");
	inOrderHelper(t.getRight() );
    }

    private int maxLength() {
	// returns the minimum number of characters required
	// to print the data from any node in the tree
	if (root == null)
	    return 0;
	return maxLength(root);
    }

    private int maxLength(TreeNode<T> curr) {
	int max = curr.toString().length();
	int temp;
	if (curr.getLeft() != null) {
	    temp = maxLength(curr.getLeft());
	    if (temp > max)
		max = temp;
	}
	if (curr.getRight() != null) {
	    temp = maxLength(curr.getRight());
	    if (temp > max)
		max = temp;
	}
	return max;
    }

    //Denis' code

    private String spaces(double n) {
	// returns a String of n spaces
	String result = "";
	for (int i = 0; i < n; i++)
	    result += " ";
	return result;
    }

    /*
      getLevel will produce a String for each level of the tree.
      The resulting Strings will look like this:

      ._______________________________
      ._______________._______________
      ._______._______._______._______
      .___.___.___.___.___.___.___.___
      ._._._._._._._._._._._._._._._._

      toString will combine those Strings and provide an output that
      will look like this:

      _______________.
      _______._______________.
      ___._______._______._______.
      _.___.___.___.___.___.___.___.
      ._._._._._._._._._._._._._._._.

      In these diagrams, each dot represents wordLength characters,
      each underscore represents wordLength spaces, and, for any nodes
      that are null, the dots will be "replaced" by underscores.
    */

    private String getLevel(TreeNode<T> curr, int currLevel, int targetLevel, int height, int wordLength) {
	if (currLevel == 1)
	    return curr.toString() + spaces(wordLength - curr.toString().length()) +
		spaces(wordLength * Math.pow(2, height - targetLevel + 1) - wordLength);
	String result = "";
	if (curr.getLeft() != null)
	    result += getLevel(curr.getLeft(), currLevel - 1, targetLevel, height, wordLength);
	else result += spaces(wordLength * Math.pow(2, height - targetLevel + currLevel - 1));
	if (curr.getRight() != null)
	    result += getLevel(curr.getRight(), currLevel - 1, targetLevel, height, wordLength);
	else result += spaces(wordLength * Math.pow(2, height - targetLevel + currLevel - 1));
	return result;
    }

    public String toString() {
	if (root == null)
	    return "";
	String result = "";
	int height = getHeight();
	int wordLength = maxLength();
	// add the every level of the tree except the last one
	for (int level = 1; level < height; level++)
	    // remove extra spaces from the end of each level's String to prevent lines from
	    // getting unnecessarily long and add spaces to the front of each level's String
	    // to keep everything centered
	    result += spaces(wordLength * Math.pow(2, height - level) - wordLength) +
		getLevel(root, level, level, height, wordLength).replaceFirst("\\s+$", "") +
		"\n";
	// now add the last level (level = height)
	result += getLevel(root, height, height, height, wordLength).replaceFirst("\\s+$", "");
	return result;
    }
}