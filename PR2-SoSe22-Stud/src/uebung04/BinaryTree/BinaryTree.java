package uebung04.BinaryTree;

import graphvisualizer.TreeVisualizer;
import pr2.util.QueueImpl;

import static gdi.MakeItSimple.isFilePresent;
import static gdi.MakeItSimple.println;
import static pr.MakeItSimple.print;
import static pr.MakeItSimple.readIntegerArray;

/**
 * @author Johannes , Julian ,Selin
 * @since 2022-04
 */

public class BinaryTree implements Tree {

    public TreeNode root;


    public BinaryTree() { // without parameter, root is null
        this.root = null;
    }

    public BinaryTree(Element rootValue) { // parameter to set the first element
        this.root = new TreeNode(rootValue); // creates new TreeNode (new Tree)
    }

    /**
     * Insert method adds an Element to the BinaryTree
     *
     * @return true if the adding is accepted
     * @return false if the adding is rejected
     */

    public boolean insertRecursively(Comparable elem){
        if(this.root == null){
            this.root = new TreeNode(elem);
            return true;
        }
        return insertRecursively(this.root, elem);
    }

    private boolean insertRecursively(TreeNode node, Comparable elem){
        if(node == null) {
            node = new TreeNode(elem);
            return true;
        }

        if(elem.compareTo(node.getElement()) == 0)
            return false;

        if(elem.compareTo(node.getElement()) == -1){
            if(node.getLeft() == null){
                node.setLeft(new TreeNode(elem));
                return true;
            }else {
                return insertRecursively(node.getLeft(), elem);
            }
        }


        if(elem.compareTo(node.getElement()) == 1)
            if(node.getRight() == null){
                node.setRight(new TreeNode(elem));
                return true;
            }else{
                return insertRecursively(node.getRight(), elem);
            }
        return true;
    }
    @Override
    //true if inserted
    // false if error occurred

    public boolean insert(Comparable val) {

        TreeNode parent = null;
        TreeNode child = root;

        while (child != null) { // at least 1 node in tree
            parent = child;

            //if (val.compareTo(child.getElement()) == 0) causes problems
            if (val.compareTo(child.getElement()) == 0) {
                return false;   // element already in tree, i is not inserted
            }
            //else if ( val.compareTo(child.getElement()) < 0)

            else if (val.compareTo(child.getElement()) < 0)
                child = child.getLeft(); // insert in left tree
            else
                child = child.getRight(); // insert in right tree

        }

        if (parent == null) // empty tree -> insert first node
            root = new TreeNode(val);
            //else if (val.compareTo(parent.getElement()) < 0)
        else if (val.compareTo(parent.getElement()) < 0)
            parent.setLeft(new TreeNode(val)); // insert left from parent
        else
            parent.setRight(new TreeNode(val)); // insert right from parent
        return true; // i successfully inserted
    }

    // inserts the data from a file to the binary tree
    @Override
    public boolean insertFromFile(String filename) {
        boolean insertedElement = false;
        if (isFilePresent(filename)) {
            int[] elements = readIntegerArray(filename); // reads the file into an array (elements)
            for (int element : elements) { // for each loop for elements
                print(element);
                if (this.insert(Integer.valueOf(element))) // if the element is added correctly
                    insertedElement = true; // set insertedElement to true
            }
        } else
            println(" File not found."); // if the file is not present / wrong path

        return insertedElement; //successful inserted elements from file
    }

    // saves the binary tree data to a file
    @Override
    //TODO: fix
    public boolean saveToFile(String filename) {
        Comparable[] array = new Comparable[this.size()]; // init array to save in
        if (saveToFile(this.root, array, 0) == 0) // if the root is empty return false
            return false;
        //saveIntegerArray(array, filename); // saves the array to a file
        return true; // return ture if everything is accepted
    }

    private int saveToFile(TreeNode root, Comparable[] array, int index) { // fills the array with the elements
        // if the root is empty return false
        if (root == null) return index;
        array[index++] = root.getElement(); // adds to array a key and increments the index
        index = saveToFile(root.getLeft(), array, index); // go recursive left
        index = saveToFile(root.getRight(), array, index);// go recursive right
        return index; // returns the end index
    }

    @Override
    public boolean contains(Comparable val) {
        TreeNode child = root; // child ist the root
        boolean found = false; // init found to false

        while (!found && child != null) {
            //search for the element which should be deleted
            if (val.compareTo(child.getElement()) == 0) { // if 0, the elements are equal
                //break loop
                found = true; // set found to true
                continue; // jump to the top of the loop
            }
            if (val.compareTo(child.getElement()) == -1) { // if 1, the child is bigger than the val
                //go left
                child = child.getLeft(); // go the left branch
                continue;
            }
            if (val.compareTo(child.getElement()) == 1) {// if 1, the child is smaller than the val
                //go Right
                child = child.getRight(); // go the right branch
                continue;
            }
        }
        return found; // return found
    }

    @Override
    public int size() {
        return size(this.root);
    }


    private int size(TreeNode node) {
        if (node == null)
            return 0;
        else
            return (size(node.left) + 1 + size(node.right));
    }

    @Override
    public int height() { //returns the height of the tree ( levels+1)
        // checks if not empty
        if (this.isEmpty()) // if the root is empty return 0
            return 0;
        else {
            TreeNode n = this.root;    //calculate the height recursively
            return height(n); // call the private method
        }
    }

    public int height(TreeNode n) {
        int heightLeft = 0;
        int heightRight = 0;
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

    @Override
    public Comparable getMax() { // returns the max Element
        if(this.root == null)
            return null;
        TreeNode n = this.root;
        while (n.getRight() != null) {
            n = n.getRight();    //go right as long as there are remaining elements
        }
        return n.getElement(); // gets the last element right

    }




    private TreeNode getMin(TreeNode k) { // used in remove method
        TreeNode n = k; // set a new treenode to k
        while (n.getLeft() != null) { // loop as long as the getRight is not null write the get right to n
            n = n.getLeft();
        }
        return n; // return n

    }

    @Override
    public Comparable getMin() {// returns min element
        if(this.root == null)
            return null;
        TreeNode n = this.root;
        while (n.getLeft() != null) {
            n = n.getLeft();    //go left as long as there are remaining elements
        }
        return n.getElement(); // gets the last element left
    }

    @Override
    public boolean remove(Comparable val) {
        //first to element has to be found, then all references have to be refreshed
        TreeNode parent = null;
        TreeNode child = root;
        boolean found = false;

        if (!contains(val)) {   //checks if the value is contained by the tree
            println("Element does not exist");
            return false;
        }
        while (!found && child != null) {
            //search for the element which should be deleted
            if (val.compareTo(child.getElement()) == 0) {
                //break loop
                found = true;
            }

            if (val.compareTo(child.getElement()) == -1) {
                //go left
                parent = child;
                child = child.getLeft();
                continue;
            }
            if (val.compareTo(child.getElement()) == 1) {
                //go Right
                parent = child;
                child = child.getRight();

            }

        }
        //child will be deleted
        if (child == this.root) {    //delete root
            if (child.getLeft() == null)
                this.root = child.getRight();    //replace the root with right element
            else if (child.getRight() == null)
                this.root = child.getLeft();    //replace the root with left element
            else {
                //replace the root with biggest element from left tree
                TreeNode k = getMin(child.getRight());
                Comparable remember = k.getElement();
                remove(k.getElement()); // recursive call
                this.root.setKey(remember); // recursive backwards
            }
        } else {
            //delete a normal node

            if (child.getLeft() == null) {  //node has no left child
                //parent is stored in local object partent
                if (parent.getLeft() == child) {
                    parent.setLeft(child.getRight());
                } else {
                    parent.setRight(child.getRight());
                }
            } else if (child.getRight() == null) {  //node has no right child
                if (parent.getLeft() == child) {
                    parent.setLeft(child.getLeft());
                } else {
                    parent.setRight(child.getLeft());
                }
            } else {    //node has 2 childs
                //TreeNode k = getMax(child.getLeft());
                TreeNode k = getMin(child.getRight());
                Comparable remember =  k.getElement();
                remove(k.getElement());
                child.setKey(remember);
            }

        }
        return true;
    }

    @Override
    public boolean isEmpty() { // returns a boolean, checks if the binary tree is empty
        return (this.root == null);
    }

    @Override
    public void clear() {
        this.root = null; // clears entire tree
    }


    @Override
    public Tree addAll(Tree otherTree) { // adds all elements of otherTree to currentTree
        TreeNode child = ((BinaryTree) otherTree).root;
        if (child != null) { // when child is not empty
            this.insert(child.getElement()); // adds element
            addAll(child.getLeft(), this); // calls the private method for left and right
            addAll(child.getRight(), this);
        }
        return this; // returns the Tree
    }

    private void addAll(TreeNode n, BinaryTree b) {
        if (n != null) { // if the TreeNode is not null
            b.insert(n.getElement()); // add an element to the tree (this)
            if (n.getLeft() != null) // when the left side is not null
                addAll(n.getLeft(), b); // recursive call for the left side of each element
            if (n.getRight() != null) // when the right side is not null
                addAll(n.getRight(), b);// recursive call for the right side of each element
        }

    }

    @Override
    public void printInorder() {
        this.printInorder(this.root); // calls private method

    }

    private void printInorder(TreeNode n) {
        if (n != null) {
            printInorder(n.getLeft()); // recursive call
            print( n.getKey() + " "); // prints out
            printInorder(n.getRight());
        }
    }

    @Override
    public void printPostorder() {
        printPostorder(this.root);

    }

    private void printPostorder(TreeNode n) {
        if (n != null) {

            printPostorder(n.getLeft()); // go left
            printPostorder(n.getRight());
            print( n.getKey() + " "); // print when the recursion goes back
        }

    }

    @Override
    public void printPreorder() {
        this.printPreorder(this.root);// calls method
    }

    private void printPreorder(TreeNode n) { // recursive
        if (n != null) {// tree not empty
            print(n.getKey() + " ");
            printPreorder(n.getLeft());
            printPreorder(n.getRight());
        }
    }

    @Override
    public void printLevelorder() {
        this.printLevelorder(this.root);
    }


    private void printLevelorder(TreeNode k) {
        if(k == null)   return;
        QueueImpl queue = new QueueImpl(); // init queue
        queue.enter(k); // adds k to queue
        while (!queue.isEmpty()) { // go in the while when queue is not empty
            TreeNode n = (TreeNode) queue.leave();

            print(n.getKey() + " "); // print out with recursion
            if(n.getLeft() != null)
                queue.enter(n.getLeft()); // recursive call in queue to write all elements in queue
            if(n.getRight() != null)
                queue.enter(n.getRight());

        }
    }

    @Override
    public Tree clone() {
        BinaryTree treeClone = new BinaryTree();
        treeClone.root = clone(this.root); // calls the private method with clone(this.root)
        return treeClone;
    }

    private TreeNode clone(TreeNode root) {
        if (root == null) { // if root is null then return null
            return null;
        }
        TreeNode nodeClone = new TreeNode((Comparable) root.getKey()); // gets each element from root
        //TreeNode nodeClone = new TreeNode(this.root.getElement());
        nodeClone.left = clone(root.getLeft());
        nodeClone.right = clone(root.getRight()); // recursive call for both sides
        return nodeClone; // returns the cloned root
    }

    @Override
    public boolean equals(Object other) { // compares structure and values
        if (!(other instanceof Tree)) // if the Object is no instance of the Tree and the BinaryTree then return false
            return false;
        if (!(other instanceof BinaryTree))
            return false;
        QueueImpl queueTree1 = new QueueImpl();
        QueueImpl queueTree2 = new QueueImpl();
        queueTree1.enter(this.root); // enter root to queue 1
        queueTree2.enter(((BinaryTree) other).root); // enter the root of other to queue 2
        while (!queueTree1.isEmpty() && !queueTree2.isEmpty()) { // loop while the queues are not empty
            TreeNode n1 = (TreeNode) queueTree1.leave(); // write elements from the queue in a new treenode
            TreeNode n2 = (TreeNode) queueTree2.leave();

            if (n1 != null && n2 != null) { // if the treenodes are both not null
                if ((n1.getElement()).compareTo(n2.getElement()) != 0) // compare n1 and n2 whether they are not equal, return false
                    return false;
            }
            if (n1 != null) { // go through the elements of n1 and add them to the queue 1
                queueTree1.enter(n1.getLeft()); // get the left and the right node of n1
                queueTree1.enter(n1.getRight());
            }
            if (n2 != null) {
                queueTree2.enter(n2.getLeft());// get the left and the right node of n2
                queueTree2.enter(n2.getRight());
            }
        }
        if (queueTree1.isEmpty() ^ queueTree2.isEmpty())
            return false;
        return true;
    }

    @Override
    public boolean equal(Tree otherTree) { // compares the values
        if (!(otherTree instanceof BinaryTree))
            return false;
        Comparable currentTreeElements[] = this.convertTreeToArray(this); // convert the current tree to an array
        Comparable otherTreeElements[] = ((BinaryTree) otherTree).convertTreeToArray(otherTree); // convert the otherTree to an array

        if (currentTreeElements.length != otherTreeElements.length) // if both arrays have not the same length return false
            return false;

        //search the equal values in both trees
        for (Comparable i : currentTreeElements) { // for each loop for the first array
            boolean found = false; // set found boolean to false
            for (Comparable i2 : otherTreeElements) { // for each loop for the second array
                if (i.compareTo(i2) == 0) // compare one value of array 1 with all values from array 2
                    found = true; // if one is equal set found to true
            }
            if (!found) // if one value is not in the other array return false
                return false;
        }
        return true; // at the end return true, because all elements are equal

    }

    private Comparable[] convertTreeToArray(Tree t) { // converts a tree to an array
        Comparable[] array = new Comparable[t.size()];
        saveToFile(((BinaryTree) t).root, array, 0); // calls method saveToFile  (private) writes the elements into the array
        return array; // return the array
    }

    @Override
    public Tree createTree() {
        return new BinaryTree(); // creates a new BinaryTree
    }

    @Override
    public void visualize() {
        TreeVisualizer t = new TreeVisualizer(); // visualizes a tree
        t.draw(root); // draw the root to the window

    }

}
