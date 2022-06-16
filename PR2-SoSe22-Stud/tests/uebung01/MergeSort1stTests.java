package uebung01;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeTrue;
import static gdi.MakeItSimple.closeInputFile;
import static gdi.MakeItSimple.closeOutputFile;
import static gdi.MakeItSimple.openInputFile;
import static gdi.MakeItSimple.openOutputFile;
import static gdi.MakeItSimple.readInt;
import static gdi.MakeItSimple.isEndOfInputFile;
import static gdi.MakeItSimple.isFilePresent;
import static gdi.MakeItSimple.print;
import static gdi.MakeItSimple.println;
import static pr.MakeItSimple.*;

import org.junit.Test;

import uebung01.MergeSort;
import uebung01.NatuerlicherMergeSort;
import uebung01.DirekterMergesort;

public class MergeSort1stTests {

	/*
	 * @Test public void test() { fail("Not yet implemented"); }
	 */

	@Test
	public void natuerlicherMergeSortTest() { // same test as streightMergeSortTest, behave / comments are the same 
		MergeSort m = new MergeSort();
		String path1 = "C:\\Users\\Johannes\\git\\Team-03\\PR2-SoSe22-Stud\\inputFiles\\numbers01.txt";
		String path2 = "C:\\Users\\Johannes\\git\\Team-03\\PR2-SoSe22-Stud\\inputFiles\\numbers02.txt";
		String path3 = "C:\\Users\\Johannes\\git\\Team-03\\PR2-SoSe22-Stud\\inputFiles\\numbers03.txt";
		String pathForTestFile = "C:\\Users\\Johannes\\git\\Team-03\\PR2-SoSe22-Stud\\mergeMethodTest";
		String paths[] = {path1, path2, path3};
		
		for (String path : paths) {
			m.naturalMergeSort(path, pathForTestFile);
			
			Object file = openInputFile("C:\\Users\\Johannes\\git\\Team-03\\PR2-SoSe22-Stud\\mergeMethodTest");
			int lastElement = readInt(file);
			try {
				while(!isEndOfInputFile(file)) {
					int currentElement = readInt(file);
					if(lastElement > currentElement)
						fail("Falsche Reihenfolge => Algorithmus ist fehlerhaft");
					lastElement = currentElement;
				}
			}catch (Exception e) {
				assumeTrue("Algorithmus korrekt, alle Elemente in der richtigen Reihenfolge", true);
			}
			assumeTrue("Algorithmus korrekt, alle Elemente in der richtigen Reihenfolge", true);	//will be executed if all elements are in the correct order
			//checkIfCorrectSorted
		}	
	}
	
	@Test
	public void straightMergeSortTest() {
		MergeSort m = new MergeSort();
		
		// basic files to run
		String path1 = "C:\\Users\\julia\\git\\Team-03\\PR2-SoSe22-Stud\\inputFiles\\numbers01.txt";
		String path2 = "C:\\Users\\julia\\git\\Team-03\\PR2-SoSe22-Stud\\inputFiles\\numbers02.txt";
		String path3 = "C:\\Users\\julia\\git\\Team-03\\PR2-SoSe22-Stud\\inputFiles\\numbers03.txt";
		String pathForTestFile = "C:\\Users\\julia\\git\\Team-03\\PR2-SoSe22-Stud\\mergeMethodTest";
		String paths[] = {path1, path2, path3};
		/* loops through the paths and checks each
		 * whether the numbers are sorted rightly*/
		for (String path : paths) {
			m.straightMergeSort(path, pathForTestFile); // opens the method with the parameters 
			
			Object file = openInputFile(pathForTestFile); // opens the sorted file 
			int lastElement = readInt(file);  // reads first Element to check
			try {
				while(!isEndOfInputFile(file)) { // loop through the file
					int currentElement = readInt(file);
					if(lastElement > currentElement)
						fail("Falsche Reihenfolge => Algorithmus ist fehlerhaft"); // fails when one element is not in order
					lastElement = currentElement; // writes the currentElement to the lastElement because the order is correct
				}
			}catch (Exception e) {
				assumeTrue("Algorithmus korrekt, alle Elemente in der richtigen Reihenfolge", true); 
			}
			assumeTrue("Algorithmus korrekt, alle Elemente in der richtigen Reihenfolge", true);	//wird erst ausgeführt, wenn alle Element an der korrekten Position stehen
			//checkIfCorrectSorted
		}	
	}
	
}
