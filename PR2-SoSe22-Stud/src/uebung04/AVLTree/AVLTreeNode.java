package uebung04.AVLTree;

import uebung04.BinaryTree.TreeNode;

public class AVLTreeNode extends TreeNode {

    int balance;
    boolean isBalanced;

    public AVLTreeNode(Comparable i) {
        super(i);
    }

    public AVLTreeNode(Comparable value, AVLTreeNode left, AVLTreeNode right){
        super(value);
        this.setLeft(left);
        this.setRight(right);
        this.balance = 0;
    }

    private AVLTreeNode rotateLeft(AVLTreeNode t){
        AVLTreeNode tmp = (AVLTreeNode) t.getRight();
        t.setRight(t.getRight().getLeft());
        tmp.setLeft(t);
        return tmp;
    }

    private AVLTreeNode rotateRight(AVLTreeNode t){
        AVLTreeNode tmp = (AVLTreeNode) t.getLeft();
        t.setLeft(t.getLeft().getRight());
        tmp.setRight(t);
        return tmp;
    }
}
