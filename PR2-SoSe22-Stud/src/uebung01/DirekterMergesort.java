package uebung01;

import static gdi.MakeItSimple.closeInputFile;
import static gdi.MakeItSimple.closeOutputFile;
import static gdi.MakeItSimple.isEndOfInputFile;
import static gdi.MakeItSimple.isFilePresent;
import static gdi.MakeItSimple.openInputFile;
import static gdi.MakeItSimple.openOutputFile;
import static gdi.MakeItSimple.print;
import static gdi.MakeItSimple.println;
import static gdi.MakeItSimple.readInt;



public class DirekterMergesort {

//	public static void main(String[] args) {
//		runMergeSort("C:\\Users\\julia\\git\\Team-03\\PR2-SoSe22-Stud\\inputFiles\\numbers03.txt","C:\\Users\\julia\\git\\Team-03\\PR2-SoSe22-Stud\\mergeMethodTest");
//	}

	public  void runMergeSort(String source ,String targetFile) {

		int cntElements = 1; //how much Elements are in the file (1 to activate the for loop)
		// Files 
		String tape_0 = source;
		String tape0change = targetFile;
		String tape_1 = "tape_1";
		String tape_2 = "tape_2";
		boolean check  = checkIfPresent(source,tape_1 , tape_2, tape0change); // check if the files are present
		for (int runlength = 1; cntElements >= runlength && check; runlength *= 2) { // loops as long as the run length is smaller/ equal than cntElements and check is true;
			// the run length goes up by the power of two
			cntElements = split(tape_0,tape_1,tape_2, runlength); // cntElements gets the value of the Element from split(...) 
			tape_0 = tape0change; // changes the tape0 to the target file
			merge(runlength,tape_0 );
			
		}
	}

	public  int split(String tape_0,String tape_1,String tape_2, int length) {

		// initialize Object streams
		Object tape0 = openInputFile(tape_0);
		Object tape1 = openOutputFile(tape_1);
		Object tape2 = openOutputFile(tape_2);
		
		int cnt = 0; // count variable( how much elements are in the file)
		int in = 0; // input 
		while (!isEndOfInputFile(tape0)) {

			for (int i = 0; i < length; i++) { // loop to the length of the Math.pow(2,n)
				if (!isEndOfInputFile(tape0)) { 
					in = readInt(tape0); 
					print(tape1, " " + in);
					cnt++; // add one element to count number
				}
			}
			for (int i = 0; i < length; i++) {
				if (!isEndOfInputFile(tape0)) {
					in = readInt(tape0);
					print(tape2, " " + in);
					cnt++;
				}
			}
		}
		//close the file streams
		closeInputFile(tape0);
		closeOutputFile(tape1);
		closeOutputFile(tape2);
		return cnt; //return number of Elements
	}

	public  void merge(int runlength, String path) {

		String tape_0 = path;
		String tape_1 = "tape_1";
		String tape_2 = "tape_2";
		
		
		Object target = openOutputFile(tape_0);
		Object tape1 = openInputFile(tape_1);
		Object tape2 = openInputFile(tape_2);
		int cntElementsWroteTape1 = 0;//counter for elements 
		int cntElementsWroteTape2 = 0;
		int currentElementTape1 = 0;// elements
		int currentElementTape2 = 0;
		boolean write1 = true; // boolean to check if written
		boolean write2 = true;
		/*print as long as both files are not done
		 * it checks the boolean write1 and wirte2 if the read Element of the tape is already printed.
		 * If one file is done and the other not, it prints as long as the other one is done too
		 * */
		while (!isEndOfInputFile(tape1) || !isEndOfInputFile(tape2) || !write1 || !write2) {

			if (!isEndOfInputFile(tape1) && cntElementsWroteTape1 < runlength && write1) {
				// print current element from tape1
				currentElementTape1 = readInt(tape1);
				write1 = false; // set to false because the new element is not written 

			}

			if (!isEndOfInputFile(tape2) && cntElementsWroteTape2 < runlength && write2) {
				// print current element from tape2
				currentElementTape2 = readInt(tape2);

				write2 = false;
			}
			
			// check if element 1 is smaller than element 2
			if (!write1 && (currentElementTape1 <= currentElementTape2 || write2)) {
				print(target, " " + currentElementTape1); //write element 1
				write1 = true;// set true to activate the if block to read a new Integer 
				cntElementsWroteTape1++; // add one to counter 
			// check if element 2 is smaller than element 1
			} else if (!write2 && (currentElementTape2 <= currentElementTape1 || write1)) { 
				
				print(target, " " + currentElementTape2); // write element 2
				write2 = true;
				cntElementsWroteTape2++;
			}
			//set both counters to 0 when 
			if (cntElementsWroteTape1 == runlength && cntElementsWroteTape2 == runlength) {
				cntElementsWroteTape1 = 0;
				cntElementsWroteTape2 = 0;
			}
		}// loop through all Elements

		closeInputFile(tape2);
		closeInputFile(tape1);
		closeOutputFile(target);

		

	}
	
	public  boolean checkIfPresent(String path, String tape1, String tape2, String tape0) {
		String tape_1 = tape1;
		String tape_2 = tape2;
		String tape_0 = tape0;
		
		/*checks whether all files are present, if one does not exist , the method returns false. Else true*/
		if (!isFilePresent(path)) {
			println(path + " existiert nicht ");
			return false;
		}
		if (!isFilePresent(tape_1)) {
			println(tape_1 + " existiert nicht ");
			return false;
		}
		if (!isFilePresent(tape_2)) {
			println(tape_2 + " existiert nicht ");
			return false;
		}
		if (!isFilePresent(tape_0)) {
			println(tape_0 + " existiert nicht ");
			return false;
		}
		return true;
	}
}