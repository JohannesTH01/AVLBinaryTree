package uebung04.AVLTree;

import uebung04.BinaryTree.TreeNode;

public class AVLTreeNode extends TreeNode {

    int balance;
    boolean isBalanced;
    AVLTreeNode parent;

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

    public AVLTreeNode rotateRight(AVLTreeNode t){
        AVLTreeNode tmp = (AVLTreeNode) t.getLeft();
        t.setLeft(t.getLeft().getRight());
        tmp.setRight(t);
        return tmp;
    }

    public int calculateBalance(){
        int balanceRightSubTree = height(this.getRight());
        int balanceLeftSubTree = height(this.getLeft());

        this.balance = balanceLeftSubTree - balanceRightSubTree;
        if(balance < -1 || balance > 1)
            isBalanced = false;
        else
            isBalanced = true;
        return this.balance;
    }

    private int height(TreeNode n) {
        int heightLeft = 0;
        int heightRight = 0;
        if(n == null)
            return 0;

        if (n.getLeft() != null)
            heightLeft = height(n.getLeft()); // recursive call
        if (n.getRight() != null)
            heightRight = height(n.getRight());
        if (heightLeft > heightRight) { // checks which branch is longer
            return heightLeft + 1; // levels +1
        } else {
            return heightRight + 1;
        }
    }
}
