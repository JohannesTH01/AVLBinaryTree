package uebung02;

import org.junit.Test;

import uebung02.BinaryTree.BinaryTree;
import uebung02.BinaryTree.IntElement;
import uebung02.BinaryTree.Tree;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.invoke.MethodHandles;

public class BinaryTree1stTest {

	private Tree tree1 = new BinaryTree();
	private Tree tree2 = new BinaryTree();
	private Tree tree3 = new BinaryTree();
    String filename = MethodHandles.lookup().lookupClass().getResource("treeInput.txt").getPath();  // hier Dateinamen ändern --> Werte von Datei einlesen

    
    // Tests mit Int-Elementen - alle einzeln eingelesen
    
    
	@Test
	public void simpleTestsInputDirect() throws Exception {  // einfache Tests

		assertEquals(true, tree1.insert(new IntElement(10)));
		assertEquals(true, tree1.insert(new IntElement(5)));
		assertEquals(true, tree1.insert(new IntElement(20)));
		assertEquals(true, tree1.insert(new IntElement(1)));
		assertEquals(true, tree1.insert(new IntElement(8)));
		assertEquals(true, tree1.insert(new IntElement(15)));
		assertEquals(true, tree1.insert(new IntElement(40)));
		assertEquals(true, tree1.insert(new IntElement(12)));
		assertEquals(true, tree1.insert(new IntElement(18)));
		assertEquals(true, tree1.insert(new IntElement(30)));
		assertEquals(true, tree1.insert(new IntElement(60)));
		assertEquals(true, tree1.insert(new IntElement(35)));
		assertEquals(true, tree1.insert(new IntElement(50)));
		assertEquals(true, tree1.insert(new IntElement(80)));
		assertEquals(true, tree1.insert(new IntElement(33)));
		assertEquals(true, tree1.insert(new IntElement(38)));
		
		// Tests - einfache
		assertEquals(16, tree1.size());
		assertEquals(6, tree1.height());
		assertEquals(0, tree1.getMax().compareTo(new IntElement(80)));
		assertEquals(0, tree1.getMin().compareTo(new IntElement(1)));		
		assertEquals(false, tree1.isEmpty());
		assertEquals(false, tree1.contains(new IntElement(3)));
		assertEquals(true, tree1.contains(new IntElement(30)));
		assertEquals(false, tree1.remove(new IntElement(31)));  // Entfernen eines Wertes, der nicht im Baum ist

		
		// Traversieren - zur Kontrolle des Aussehens des Baums
		
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
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
	

//	  @Test public void difficultTestsInputFromFile() throws Exception { //schwierige Tests: Löschen, Clone
//
//	  assertEquals(true, tree1.insertFromFile(filename)); assertEquals(false,
//	  tree1.insertFromFile(filename));
//
//
//	  tree3 = tree1.clone(); // tree3 ist Klon von tree1
//
//	  tree3.remove(new IntElement(10)); // Wurzelknoten entfernen
//	  assertEquals(false, tree3.contains(new IntElement(10))); assertEquals(true,
//	  tree1.contains(new IntElement(10))); // testet, dass Änderungen im Klon sichnicht auf Original auswirken
//
//	  tree1.remove(new IntElement(40)); // Tests von Löschungen assertEquals(15,
//	  tree1.size(); assertEquals(6, tree1.height());
//
//	  tree1.remove(new IntElement(30)); assertEquals(14, tree1.size());
//	  assertEquals(5, tree1.height());
//
//	  tree1.remove(new IntElement(35)); assertEquals(13, tree1.size());
//	  assertEquals(5, tree1.height());
//
//	  // Traversieren - zur Kontrolle des Aussehens des Baums
//
//	  ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//	  System.setOut(new PrintStream(outContent));
//
//	  // Ausgabe der Werte des Baums von Konsole auf outContent umgeleitet
//
//	  tree1.printPostorder(); String expectedOutputPO =
//	  "1 8 5 12 18 15 33 38 80 60 50 20 10 ";
//
//	  assertEquals(expectedOutputPO, outContent.toString()); // Test Postorder
//
//
//	  outContent = new ByteArrayOutputStream(); System.setOut(new
//	  PrintStream(outContent));
//
//
//	  tree1.printInorder(); String expectedOutputIO =
//	  "1 5 8 10 12 15 18 20 33 38 50 60 80 ";
//
//	  assertEquals(expectedOutputIO, outContent.toString()); // Test Inorder
//
//	  outContent = new ByteArrayOutputStream(); System.setOut(new
//	  PrintStream(outContent));
//
//	  tree1.printPreorder(); String expectedOutputPreO =
//	  "10 5 1 8 20 15 12 18 50 38 33 60 80 ";
//
//	  assertEquals(expectedOutputPreO, outContent.toString()); // Test Preorder
//
//	  outContent = new ByteArrayOutputStream(); System.setOut(new
//	  PrintStream(outContent));
//
//
//	  tree1.printLevelorder(); String expectedOutputLO =
//	  "10 5 20 1 8 15 50 12 18 38 60 33 80 ";
//
//	  assertEquals(expectedOutputLO, outContent.toString()); // Test Levelorder
//
//
//
//	  tree1.clear(); assertEquals(0, tree1.size());
//
//	  tree1.insertFromFile(filename);
//
//	  tree2 = tree1.clone(); // tree2 ist Klon von tree1 tree1.addAll(tree2); //Füge denselben Baum (tree2) in tree1 ein.
//	  assertEquals(tree1.size(),
//	  tree2.size());
//
//	  }
//
//
}
