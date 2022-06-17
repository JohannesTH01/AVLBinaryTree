package uebung04.AVLTree;

import uebung04.BinaryTree.BinaryTree;
import uebung04.BinaryTree.TreeNode;

import static pr.MakeItSimple.println;

public class  AVLTree extends BinaryTree {
    public AVLTree(){
        super();
    }

    @Override
    public boolean insertRecursively(Comparable elem){
        if(this.root == null){
            this.root = new AVLTreeNode(elem);
            return true;
        }

        return this.add((AVLTreeNode) this.root, new AVLTreeNode(elem));
    }

    public boolean add(AVLTreeNode parentNode, AVLTreeNode newNode){
        println("insert:" + newNode.getElement());
        int comparisonResult = newNode.getElement().compareTo(parentNode.getElement());
        println(comparisonResult);

        if(newNode.getElement().compareTo(parentNode.getElement()) == 1) {
            if(parentNode.getRight() == null){
                parentNode.setRight(newNode);
            }else{
                this.add((AVLTreeNode) parentNode.getRight(), newNode);
            }
        }

        if(newNode.getElement().compareTo(parentNode.getElement()) == -1){
            println("insert left");
            if(parentNode.getLeft() == null){
                parentNode.setLeft(newNode);
            }else{
                this.add((AVLTreeNode) parentNode.getLeft(), newNode);
            }
        }else{
            return false;   //element alrey inserted
        }

        checkBalance(newNode);
        return true;
    }

    private void checkBalance (AVLTreeNode node){
        node.calculateBalance();
        println("Node: " +node.getElement() + " is balances ?" + node.isBalanced);

        int balanceDifferece = height(node.getLeft()) - height(node.getRight());

        if(balanceDifferece > 1 || balanceDifferece < -1){
            //rebalance
            rebalance(node);
        }
        if(node.parent == null)
            return; //root reached

        checkBalance(node.parent);
    }

    private void rebalance(AVLTreeNode node){
        int balanceDifferece = height(node.getLeft()) - height(node.getRight());

        if(balanceDifferece > 1){
            if(height(node.getLeft().getLeft()) > height(node.getLeft().getRight())){
                node = rotateRight(node);
            }
        }
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
}
