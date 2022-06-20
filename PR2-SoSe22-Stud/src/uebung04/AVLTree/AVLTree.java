package uebung04.AVLTree;

import uebung04.BinaryTree.BinaryTree;

import static pr.MakeItSimple.println;

public class  AVLTree extends BinaryTree {
    public AVLTree(){
        super();
    }

    @Override
    public boolean insert(Comparable elem){
        this.root = insertR((AVLTreeNode) this.root, new AVLTreeNode(elem));
        return true;
    }

    private AVLTreeNode insertR(AVLTreeNode node, AVLTreeNode dataToInsert){
        if(node == null)
            return dataToInsert;
        if(dataToInsert.getElement().compareTo(node.getElement()) < 0)
            node.setLeft(insertR((AVLTreeNode) node.getLeft(), dataToInsert));
        else if(dataToInsert.getElement().compareTo(node.getElement()) > 0)
            node.setRight(insertR((AVLTreeNode) node.getRight(), dataToInsert));

        return checkForRotation(node);
    }

    private AVLTreeNode checkForRotation(AVLTreeNode currentNode){
        //calculate balance
        int balance = currentNode.calculateBalance();

        //left-heavy
        if(balance > 1){
            //do rightrotation
            if(((AVLTreeNode)currentNode.getLeft()).calculateBalance() < 0)
                currentNode.setLeft(rotateLeft((AVLTreeNode) currentNode.getLeft()));


            return rotateRight(currentNode);
        }

        //right-heavy
        if(balance < 1){
            if(((AVLTreeNode)currentNode.getRight()).calculateBalance() > 0)
                currentNode.setRight(rotateRight((AVLTreeNode) currentNode.getRight()));
            return rotateLeft(currentNode);
        }

        return currentNode;
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
