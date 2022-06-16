package uebung02.BinaryTree;

import graphvisualizer.VisualizableNode;
import graphvisualizer.VisualizableOneKeyNode;

public class TreeNode implements VisualizableOneKeyNode { // Node of a binary tree

////////////////////////class TreeNode     //////////////////////////////////
	Comparable value; // all kinds of Element can be stored in tree
	TreeNode left;
	TreeNode right;

	public TreeNode(Comparable i) {
		value = i;
		left = right = null;
	}

	public TreeNode getLeft() {
		return left;
	}

	public TreeNode getRight() {
		return right;
	}

	public Comparable getElement() {
		return value;
	}

	public void setKey(Comparable element){
		this.value = element;
	}

	public void setLeft(TreeNode n) {
		left = n;
	}

	public void setRight(TreeNode n) {
		right = n;
	}

	public void print() {
		pr.MakeItSimple.print(value + " ");
//pr.MakeItSimple.print(elem.toString() + " ");
	}

	/**
	 * @return children of this node
	 */
	public VisualizableNode[] getChildren() {

		return new VisualizableNode[] { left, right };
	}

	@Override
	public Object getKey() {
		return value;
	}

	/**
	 * @return the keys of this node.
	 */
	public Object[] getKeys() {
		return new Object[] { this.value};
	};

}