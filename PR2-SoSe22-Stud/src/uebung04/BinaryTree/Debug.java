package uebung04.BinaryTree;

import static gdi.MakeItSimple.println;

public class Debug {

    public static void main(String args[]){
       BinaryTree tree1 = new BinaryTree();
       tree1.insertFromFile("C:\\Users\\Johannes\\Desktop\\numbersdebug.txt");
        tree1.insertFromFile("C:\\Users\\Johannes\\Desktop\\numbersdebug.txt");
       tree1.size();
       tree1.height();
        tree1.getMax().compareTo(80);
        tree1.getMin().compareTo(1);
        tree1.remove(31);
        tree1.isEmpty();
        tree1.contains(3);
        tree1.contains(30);
        tree1.remove(38);
        println("insert: 100");
        println(tree1.insertRecursively(100));
        println(tree1.insertRecursively(49));
        println(tree1.insertRecursively(110));
        println(tree1.insertRecursively(90));
        println(tree1.insertRecursively(36));
        println("Delete existing one:");
        println(tree1.insertRecursively(20));

        tree1.visualize();
        println(tree1.contains(30));
        println(tree1.contains(1));
        println(tree1.contains(0));
    }
}
