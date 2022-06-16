package uebung02;

import org.junit.Test;

import uebung02.BinaryTree.BinaryTree;
import uebung02.BinaryTree.IntElement;
import uebung02.BinaryTree.Tree;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.invoke.MethodHandles;

public class BinaryTreeTest {

    private Tree tree1 = new BinaryTree();
    private Tree tree2 = new BinaryTree();
    private Tree tree3 = new BinaryTree();
    String filename = MethodHandles.lookup().lookupClass().getResource("treeInput.txt").getPath();  // hier Dateinamen ändern --> Werte von Datei einlesen


    // Tests mit Int-Elementen

    @Test
    public void demoDatei() throws Exception {  // einfache Tests
//		String filename = MethodHandles.lookup().lookupClass().getResource("treeInput.txt").getPath();
//		tree1.insert(new IntElement(10));   // nur für vereinfachte Tests
        assertEquals(true, tree1.insertFromFile(filename));
        assertEquals(false, tree1.insertFromFile(filename));
        assertEquals(16, tree1.size());
        assertEquals(6, tree1.height());
        assertEquals(0, tree1.getMax().compareTo(80));
        assertEquals(0, tree1.getMin().compareTo(1));
        assertEquals(false, tree1.remove(31));
        assertEquals(false, tree1.isEmpty());
        assertEquals(false, tree1.contains(3));
        assertEquals(true, tree1.contains(30));

        tree3 = (BinaryTree) tree1.clone();    // tree3 ist Klon von tree1

        tree3.remove(new IntElement(10));
        assertEquals(false, tree3.contains(10));
        assertEquals(true, tree1.contains(10));   // testet, dass Änderungen im Klon sich nicht auf Original auswirken

        tree1.remove(new IntElement(40));   // Tests von Löschungen
        assertEquals(15, tree1.size());
        assertEquals(6, tree1.height());

        tree1.remove(new IntElement(30));
        assertEquals(14, tree1.size());
        assertEquals(5, tree1.height());

        tree1.remove(new IntElement(35));
        assertEquals(13, tree1.size());
        assertEquals(5, tree1.height());

        tree1.clear();
        assertEquals(0, tree1.size());

//		tree1.insert(new IntElement(10));   // nur für vereinfachte Tests

        tree1.insertFromFile(filename);

        tree2 = (BinaryTree) tree1.clone();   // tree1 ist Klon von tree1
        tree1.addAll(tree2);
        assertEquals(tree1.size(), tree2.size());

//         assertEquals(false, tree1.clone().isEmpty());
//         assertEquals(true, tree1.remove(10));
//         assertEquals(true, tree1.isEmpty());
//         assertEquals(false, tree1.contains(10));
//         assertEquals(true, tree1.clone().isEmpty());
    }

    @Test
    public void testsOnEmpty() {    // Tests mit leeren Bäumen
        assertEquals(0, tree1.size());
        assertEquals(0, tree1.height());
        assertEquals(null, tree1.getMax());
        assertEquals(null, tree1.getMin());
        assertEquals(false, tree1.remove(1));
        assertEquals(true, tree1.isEmpty());
        assertEquals(false, tree1.contains(1));
        assertEquals(true, ((BinaryTree) tree1.clone()).isEmpty());
    }

    @Test
    public void insertOnlyOneElement() {  // Tests mit Bäumen, die nur aus der Wurzel bestehen
        tree1.insert(10);
        assertEquals(1, tree1.size());
        assertEquals(1, tree1.height());
        assertEquals(0, tree1.getMax().compareTo(10));
        assertEquals(0, tree1.getMin().compareTo(10));
        assertEquals(false, tree1.remove(1));
        assertEquals(false, tree1.isEmpty());
        assertEquals(false, tree1.contains(1));
        assertEquals(true, tree1.contains(10));
        assertEquals(false, ((BinaryTree) tree1.clone()).isEmpty());
        assertEquals(true, tree1.remove(10));
        assertEquals(true, tree1.isEmpty());
        assertEquals(false, tree1.contains(10));
        assertEquals(true, ((BinaryTree) tree1.clone()).isEmpty());
    }

    // Tests mit String-Elementen

//	@Test
//	public void demoDateiStrings() throws Exception {   // Einfache Tests
//
//		String filename = MethodHandles.lookup().lookupClass().getResource("treeInputStrings.txt").getPath();
//		tree1.insert(new StringElement("Hans")); // damit die Tests klappen
//		assertEquals(true, tree1.insertFromFile(filename));
//		assertEquals(false, tree1.insertFromFile(filename));
//		assertEquals(16, tree1.size());
//		assertEquals(6, tree1.height());
//		assertEquals(0, tree1.getMax().compareTo(new StringElement("Willy")));
//		assertEquals(0, tree1.getMin().compareTo(new StringElement("Andrea")));
//		assertEquals(false, tree1.remove(new StringElement("Willi")));
//		assertEquals(false, tree1.isEmpty());
//		assertEquals(false, tree1.contains(new StringElement("Willibald")));
//		assertEquals(true, tree1.contains(new StringElement("Lothar")));
//		tree3 = (BinaryTree) tree1.clone();
//
//		tree3.remove(new StringElement("Hans"));
//		assertEquals(false, tree3.contains(new StringElement("Hans")));
//		assertEquals(true, tree1.contains(new StringElement("Hans")));
//
//		tree1.remove(new StringElement("Rolf"));
//		assertEquals(15, tree1.size());
//		assertEquals(6, tree1.height());
//
//		tree1.remove(new StringElement("Norbert"));
//		assertEquals(14, tree1.size());
//		assertEquals(5, tree1.height());
//
//		tree1.remove(new StringElement("Paul"));
//		assertEquals(13, tree1.size());
//		assertEquals(5, tree1.height());
//
//		tree1.clear();
//		assertEquals(0, tree1.size());
//
////		tree1.insert(new StringElement("Hans"));   // nur für vereinfachte Tests
//
//		tree1.insertFromFile(filename);
//		tree2 = (BinaryTree) tree1.clone();
//		tree1.addAll(tree2);
//		assertEquals(tree1.size(), tree2.size());
//
//		// assertEquals(false, tree1.clone().isEmpty());
//		// assertEquals(true, tree1.remove(10));
//		// assertEquals(true, tree1.isEmpty());
//		// assertEquals(false, tree1.contains(10));
//		// assertEquals(true, tree1.clone().isEmpty());
//	}

//	@Test
//	public void testsOnEmptyStrings() {  // leere Bäume
//		assertEquals(0, tree1.size());
//		assertEquals(0, tree1.height());
////		assertEquals(null, tree1.getMax());
////		assertEquals(null, tree1.getMin());
//		assertEquals(false, tree1.remove(new StringElement("Hans")));
//		assertEquals(true, tree1.isEmpty());
//		assertEquals(false, tree1.contains(new StringElement("Hans")));
//		assertEquals(true, ((BinaryTree) tree1.clone()).isEmpty());
//	}
//
//	@Test
//	public void insertOnlyOneElementStrings() {  // Bäume, die nur aus Wurzel bestehen
//		tree1.insert(new StringElement("Hans"));
//		assertEquals(1, tree1.size());
//		assertEquals(1, tree1.height());
//		assertEquals(0, tree1.getMax().compareTo(new StringElement("Hans")));
//		assertEquals(0, tree1.getMin().compareTo(new StringElement("Hans")));
//		assertEquals(false, tree1.remove(new StringElement("Hansi")));
//		assertEquals(false, tree1.isEmpty());
//		assertEquals(false, tree1.contains(new StringElement("Hansi")));
//		assertEquals(true, tree1.contains(new StringElement("Hans")));
//		assertEquals(false, ((BinaryTree) tree1.clone()).isEmpty());               // <<< Fehler
//		assertEquals(true, tree1.remove(new StringElement("Hans")));
//		assertEquals(true, tree1.isEmpty());
//		assertEquals(false, tree1.contains(new StringElement("Hans")));
//		assertEquals(true, ((BinaryTree) tree1.clone()).isEmpty());
//	}


    // Tests für equals- und equal-Methode

    @Test
    public void test2TreesOnEquals() {

        String filename = MethodHandles.lookup().lookupClass().getResource("treeInput.txt").getPath();
        String filename3 = MethodHandles.lookup().lookupClass().getResource("treeInput3.txt").getPath();
        String filename4 = MethodHandles.lookup().lookupClass().getResource("treeInput4.txt").getPath();
        String filename5 = MethodHandles.lookup().lookupClass().getResource("treeInput5.txt").getPath();
        assertEquals(true, tree1.insertFromFile(filename));
        assertEquals(true, tree2.insertFromFile(filename));
        assertEquals(true, tree1.equals(tree2));
        assertEquals(true, tree1.remove(10));
        assertEquals(true, tree2.remove(10));
        assertEquals(true, tree1.equals(tree2));

        tree1.clear();
        tree2.clear();
        assertEquals(true, tree1.equals(tree2));
        assertEquals(true, tree1.equal(tree2));


        tree1.clear();
        tree2.clear();
        assertEquals(true, tree1.insertFromFile(filename));
        assertEquals(true, tree2.insertFromFile(filename3));

        assertEquals(false, tree1.equals(tree2));  // strukturell ungleich
        assertEquals(true, tree1.equal(tree2));    // inhaltlich gleich

        tree1.clear();
        tree2.clear();
        assertEquals(true, tree1.insertFromFile(filename4));
        assertEquals(true, tree2.insertFromFile(filename5));

        assertEquals(true, tree1.equal(tree2));  // strukturell und inhaltlich gleich

    }

    @Test
    public void testsWith16Values() { //throws Exception {

        String filename = MethodHandles.lookup().lookupClass().getResource("treeInput.txt").getPath();

        assertEquals(true, tree1.insertFromFile(filename));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        // PrintStream oldOut = System.out;
        System.setOut(new PrintStream(outContent));

        // After this all System.out.println() statements will come to
        // outContent
        // stream.

        assertEquals(16, tree1.size());

        // Ausgabe der Werte des Baums von Konsole auf outContent umgeleitet

        tree1.printPostorder();
        String expectedOutputPO = "1 8 5 12 18 15 33 38 35 30 50 80 60 40 20 10 ";

        assertEquals(expectedOutputPO, outContent.toString());  // Test Postorder


        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));


        tree1.printInorder();
        String expectedOutputIO = "1 5 8 10 12 15 18 20 30 33 35 38 40 50 60 80 ";

        assertEquals(expectedOutputIO, outContent.toString());  // Test Inorder

        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        tree1.printPreorder();
        String expectedOutputPreO = "10 5 1 8 20 15 12 18 40 30 35 33 38 60 50 80 ";

        assertEquals(expectedOutputPreO, outContent.toString());  // Test Preorder

        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));


        tree1.printLevelorder();
        String expectedOutputLO = "10 5 20 1 8 15 40 12 18 30 60 35 50 80 33 38 ";

        assertEquals(expectedOutputLO, outContent.toString());  // Test Levelorder

    }

}
