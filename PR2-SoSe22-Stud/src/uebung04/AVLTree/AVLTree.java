package uebung04.AVLTree;

import uebung04.BinaryTree.BinaryTree;
import uebung04.BinaryTree.TreeNode;

public class AVLTree extends BinaryTree {
    public AVLTree(){
        super();
    }

    public boolean insertRecursively(Comparable elem){
        if(this.root == null){
            this.root = new AVLTreeNode(elem);
            return true;
        }
        return insertRecursively(this.root, elem);
    }

    private boolean insertRecursively(TreeNode node, Comparable elem){
        if(node == null) {
            node = new AVLTreeNode(elem);
            return true;
        }

        if(elem.compareTo(node.getElement()) == 0)
            return false;

        if(elem.compareTo(node.getElement()) == -1){
            if(node.getLeft() == null){
                node.setLeft(new AVLTreeNode(elem));
                return true;
            }else {
                return insertRecursively(node.getLeft(), elem);
            }
        }


        if(elem.compareTo(node.getElement()) == 1)
            if(node.getRight() == null){
                node.setRight(new AVLTreeNode(elem));
                return true;
            }else{
                return insertRecursively(node.getRight(), elem);
            }
        return true;
    }
}
