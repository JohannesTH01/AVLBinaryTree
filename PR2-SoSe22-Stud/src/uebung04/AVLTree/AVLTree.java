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
            AVLTreeNode newNode = new AVLTreeNode(elem);
            newNode.parent = null;
            this.root = newNode;
            return true;
        }

        return this.insertR((AVLTreeNode) this.root, new AVLTreeNode(elem), 0);
    }

    public boolean insertR(AVLTreeNode parentNode, AVLTreeNode newNode, int recursiondepth){
        int comparisonResult = newNode.getElement().compareTo(parentNode.getElement());
        println(comparisonResult);

        if(newNode.getElement().compareTo(parentNode.getElement()) == 1) {
            if(parentNode.getRight() == null){
                println(newNode.getElement() + " inserted right");
                newNode.parent = parentNode;    //ref to parent for recursive balance check
                parentNode.setRight(newNode);
            }else{
                this.insertR((AVLTreeNode) parentNode.getRight(), newNode, recursiondepth++);
            }
        }

        if(newNode.getElement().compareTo(parentNode.getElement()) == -1){
            if(parentNode.getLeft() == null){
                println(newNode.getElement() + " inserted left");
                newNode.parent = parentNode;    //ref to parent for recursive balance check
                parentNode.setLeft(newNode);
            }else{
                this.insertR((AVLTreeNode) parentNode.getLeft(), newNode, recursiondepth++);
            }
        }else{
            return false;   //element already inserted
        }

        if(recursiondepth == 0)
            checkBalanceDebug(newNode);
        return true;
    }

    private void checkBalanceDebug(AVLTreeNode currentNode){
        currentNode.calculateBalance();
        if(!currentNode.isBalanced) {
            println("current node: " + currentNode.getElement() + " rebalance needed");
            //now we have to decide which type of rotation is needed

            //right rotation (for testing purposes !)
            Comparable tempValue = currentNode.getElement();
            currentNode.parent.setLeft(currentNode.getLeft());
            currentNode.parent.getLeft().setRight(new AVLTreeNode(tempValue));


            return;

        }
        else
            println("current node: " + currentNode.getElement());
        if(currentNode.parent != null)
            checkBalanceDebug(currentNode.parent);

    }
    private void checkBalance (AVLTreeNode node){
        //int this method the balance of the previously inserted node will be checked.
        //Afterwards the method checks the tree recursively for further imbalanced nodes
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
