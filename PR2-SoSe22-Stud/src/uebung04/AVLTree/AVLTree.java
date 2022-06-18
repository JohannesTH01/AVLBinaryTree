package uebung04.AVLTree;

import uebung04.BinaryTree.BinaryTree;

import static pr.MakeItSimple.println;

public class  AVLTree extends BinaryTree {
    public AVLTree(){
        super();
    }

    @Override
    public boolean insert(Comparable elem){
        if(this.root == null){
            this.root = new AVLTreeNode(elem);
            return true;
        }

        return this.insertR((AVLTreeNode) this.root, new AVLTreeNode(elem));
    }

    public boolean insertR(AVLTreeNode parentNode, AVLTreeNode newNode){
        println("insert:" + newNode.getElement());
        int comparisonResult = newNode.getElement().compareTo(parentNode.getElement());
        println(comparisonResult);

        if(newNode.getElement().compareTo(parentNode.getElement()) == 1) {
            if(parentNode.getRight() == null){
                parentNode.setRight(newNode);
            }else{
                this.insertR((AVLTreeNode) parentNode.getRight(), newNode);
            }
        }

        if(newNode.getElement().compareTo(parentNode.getElement()) == -1){
            println("insert left");
            if(parentNode.getLeft() == null){
                parentNode.setLeft(newNode);
            }else{
                this.insertR((AVLTreeNode) parentNode.getLeft(), newNode);
            }
        }else{
            return false;   //element already inserted
        }

        checkBalance((AVLTreeNode)this.root);
        return true;
    }

    private void checkBalance (AVLTreeNode node){
        int balanceDifferece = node.calculateBalance();
        println("Node: " +node.getElement() + " is balances ?" + node.isBalanced);
        if(balanceDifferece > 1 || balanceDifferece < -1 && !node.isBalanced){
            //rebalance
            rebalance(node,balanceDifferece);
        }
        if(node.parent != null)
            checkBalance(node.parent);
    }

    private void rebalance(AVLTreeNode node, int balanceDifferece){

        if(balanceDifferece > 1){
            if(node.getRight()!= null && node.getLeft() !=null)
                node.setLeft(rotateLeft(node));

        }
        if(balanceDifferece < -1){
            if(node.getRight()!= null && node.getLeft() !=null)
                node.setRight(rotateRight(node));

        }
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
