package uebung04.AVLTree;

import uebung04.BinaryTree.BinaryTree;
import uebung04.BinaryTree.TreeNode;

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
        return insertR(this.root, elem);
    }

    private boolean insertR(TreeNode node, Comparable elem){
        if(node == null) {
            node = new AVLTreeNode(elem);
            return true;
        }

        if(elem.compareTo(node.getElement()) == 0)
            return false;

        if(elem.compareTo(node.getElement()) < 0){
            if(node.getLeft() == null){
                node.setLeft(new AVLTreeNode(elem));
                return true;
            }else {
                return insertR(node.getLeft(), elem);
            }
        }
        if(elem.compareTo(node.getElement()) > 0)
            if(node.getRight() == null){
                node.setRight(new AVLTreeNode(elem));
                return true;
            }else{
                return insertR(node.getRight(), elem);
            }
        return true;
    }
}
