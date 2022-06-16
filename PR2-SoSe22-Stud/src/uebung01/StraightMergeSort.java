package uebung01;

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

public class StraightMergeSort {
	
	public static void main(String args[]) {
		StraightMergeSort m = new StraightMergeSort();
		//m.split("C:\\Users\\Johannes\\git\\Team-03\\PR2-SoSe22-Stud\\inputFiles\\numbers01.txt", 2);
		//m.merge(2, "C:\\Users\\Johannes\\git\\Team-03\\PR2-SoSe22-Stud\\mergeMethodTest");
		m.sort("C:\\Users\\Johannes\\git\\Team-03\\PR2-SoSe22-Stud\\inputFiles\\numbers02.txt", "C:\\Users\\Johannes\\git\\Team-03\\PR2-SoSe22-Stud\\mergeMethodTest");
	}
	
	public void sort(String srcFile, String newFile) {
		int runlength = 1;
		int numbers = 0;
		boolean firstRun = true;
		do {
			if(firstRun) {
				numbers = split(srcFile, runlength);
				merge(runlength, newFile);
				firstRun = false;
			}else {
				split(newFile, runlength);
				merge(runlength, newFile);
			}
			runlength = runlength * 2;
			
		}while(runlength < numbers);
		
	}
	
	private int split(String path, int runlength) {
		// Tape0 aufteilen
		String tape_0 = path;
		String tape_1 = "tape_1";
		String tape_2 = "tape_2";
	
		if (!isFilePresent(tape_0)) {
			println(tape_0 + " existiert nicht ");
			return -1;
		}
	
		Object tape0 = openInputFile(tape_0);
		Object tape1 = openOutputFile(tape_1);
		Object tape2 = openOutputFile(tape_2);
		
		boolean firstRunTape1 = true;
		boolean firstRunTape2 = true;
		boolean writeToTape1 = true;
		int counter = 0;
		int elementCnt = 0;	//counts the size of the input data
		
		while(!isEndOfInputFile(tape0)) {
			if(writeToTape1 && counter < runlength) {
				//appendToTape1
				if(firstRunTape1){
					print(tape1, readInt(tape0));
					firstRunTape1 = false;
				}else {
					print(tape1, " " + readInt(tape0));
				}
				counter++;
				elementCnt++;
				if(counter % runlength == 0){
					writeToTape1 =! writeToTape1;
					counter = 0;
				}
				continue;
			}
			
			
			if(!writeToTape1 && counter < runlength) {
				//appendToTape2
				if(firstRunTape2){
					print(tape2, readInt(tape0));
					firstRunTape2 = false;
				}else {
					print(tape2, " " + readInt(tape0));
				}
				counter++;
				elementCnt++;
				if(counter % runlength == 0){
					writeToTape1 =! writeToTape1;
					counter = 0;
				}
				continue;
			}
			
		}
		closeInputFile(tape0);
		closeOutputFile(tape1);
		closeOutputFile(tape2);
		return elementCnt;
	}


	public void merge(int runlength, String path){
		String tape_0 = path;
		String tape_1 = "tape_1";
		String tape_2 = "tape_2";
		if (!isFilePresent(tape_0)) {
			println(tape_0 + " existiert nicht ");
			return;
		}
		Object target = openOutputFile(tape_0);
		Object tape1 = openInputFile(tape_1);
		Object tape2 = openInputFile(tape_2);
		
		int cntElementsTape1 = 0;
		int cntElementsTape2 = 0;
		int currentElementTape1 = 0;
		int currentElementTape2 = 0;
		
		boolean tape1HasElements = !isEndOfInputFile(tape1);
		boolean tape2HasElements = !isEndOfInputFile(tape2);
		boolean firstRun = true;
		
		//initialization of variables
		if(tape1HasElements)
			currentElementTape1 = readInt(tape1);
		if(tape2HasElements)
			currentElementTape2 = readInt(tape2);
		
		while(tape1HasElements || tape2HasElements) {
			
			//reset counter variables
			if(cntElementsTape1 == runlength && cntElementsTape2 == runlength) {
				cntElementsTape1 = 0;
				cntElementsTape2 = 0;
			}
			
			
			
			if((currentElementTape1 <= currentElementTape2 && tape1HasElements && cntElementsTape1 < runlength) || ((cntElementsTape2 == runlength || !tape2HasElements) && tape1HasElements)) {
				if(firstRun) {
					print(target, currentElementTape1);
					firstRun = false;
				}else {
					print(target, " " + currentElementTape1);
				}
				cntElementsTape1++;
				tape1HasElements = !isEndOfInputFile(tape1);
				if(tape1HasElements) {
					currentElementTape1 = readInt(tape1);
				}
				continue;
			}
			
		
			
			
			if((currentElementTape2 < currentElementTape1 && tape2HasElements && cntElementsTape2 < runlength) || ((cntElementsTape1 == runlength || !tape1HasElements) && tape2HasElements)) {
				if(firstRun) {
					print(target, currentElementTape2);
					firstRun = false;
				}else {
					print(target, " " + currentElementTape2);
				}
				cntElementsTape2++;
				tape2HasElements = !isEndOfInputFile(tape2);
				if(tape2HasElements) {
					currentElementTape2 = readInt(tape2);
				}
				continue;
			}
			
			
			
			
			
		}
		closeInputFile(tape1);
		closeOutputFile(target);
		closeInputFile(tape2);
	}
}
