package uebung02.BinaryTree;



public interface Tree { // only int values stored in tree

        public boolean insert(Comparable val); // inserts val in tree.

        boolean insertFromFile(String filename); // inserts objects from file in tree
        // returns true if at least one element on file is really inserted

        boolean saveToFile(String filename); // stores objects from tree in file

        boolean contains(Comparable val); // checks if val is in tree

        int size(); // computes number of values in tree

        int height(); // computes height of tree

        Comparable getMax(); // returns biggest value of tree

        Comparable getMin(); // returns smallest value of tree

        boolean remove(Comparable val); // removes val from tree

        boolean isEmpty(); // checks if tree is empty

        void clear(); // removes all elements from tree

        Tree addAll(Tree otherTree); // inserts all values from
                                                 // otherTree in tree

        void printInorder(); // prints tree in inorder

        void printPostorder(); // prints tree in postorder

        void printPreorder(); // prints tree in preorder

        void printLevelorder(); // prints tree in levelorder

        Tree clone(); // creates a deep copy of tree

        boolean equals(Object other); // tests for structurally equivalence
                                      // element by element

        boolean equal(Tree otherTree); // equivalence
                                     // with regards to content
        

        Tree createTree(); // creates a new Tree
        
        void visualize (); // visualizes tree
    }
