package uebung04.AVLTree;

import uebung04.BinaryTree.TreeNode;

import static pr.MakeItSimple.println;

public class Debug {

    public static void main(String args[]){
        AVLTree t = new AVLTree();
        t.insert(4);
        t.insert(2);
        t.insert(6);
        t.insert(1);
        t.insert(0);

        t.visualize();


    }
}
