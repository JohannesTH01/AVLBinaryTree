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

public class NatuerlicherMergeSort {

	public static void natuerlicherMergeSort(String srcFile, String newFile) {
		// start sorting
		int runs = split(srcFile);
		if(runs > 1)
			merge(newFile);
		while (runs > 1) {
			runs = split(newFile);
			merge(newFile);
		}

	}

	private static int split(String path) {
		// split the inputfile into multiple runs
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

		boolean writeToTape1 = true;
		int lastInputNumber = 0;
		int currentNumber = 0;
		int cnt = 0;
		int cnt2 = 0;
		int runs = 0;

		while (!isEndOfInputFile(tape0)) {
			if (cnt == 0) {
				currentNumber = readInt(tape0); // initialization
				print(tape1, currentNumber);	//append to tape1
				lastInputNumber = currentNumber;
				cnt++;
				runs++;
				continue;
			}

			currentNumber = readInt(tape0); // read the next number

			if (currentNumber < lastInputNumber) {
				writeToTape1 = !writeToTape1;
				runs++;
			}

			if (writeToTape1) {
				print(tape1, " " + currentNumber);	//append to tape1
				cnt++;
			} else {
				if (cnt2 == 0) {
					print(tape2, currentNumber);	//append to tape2
					cnt2++;

				} else {
					print(tape2, " " + currentNumber);	//append to tape2
					cnt2++;
				}
			}
			lastInputNumber = currentNumber;

		}

		closeInputFile(tape0);
		closeOutputFile(tape1);
		closeOutputFile(tape2);

		return runs; // returns the amount of runs
	}

	private static void merge(String path) {
		String targetpath = path;
		String tape_1 = "tape_1";
		String tape_2 = "tape_2";

		if (!isFilePresent(targetpath)) {
			println(targetpath + " wird erstellt");
		}

		Object target = openOutputFile(targetpath);
		Object tape1 = openInputFile(tape_1);
		Object tape2 = openInputFile(tape_2);
		int numberTape1 = 0, numberTape2 = 0;

		boolean firstRun = true;
		boolean tape1ContainsNumbers = true;
		boolean tape2ContainsNumbers = true;

		if (firstRun) {
			// initialization
			if (!isEndOfInputFile(tape1)) {
				numberTape1 = readInt(tape1);
			} else {
				tape1ContainsNumbers = false;
			}

			if (!isEndOfInputFile(tape2)) {
				numberTape2 = readInt(tape2);
			} else {
				tape2ContainsNumbers = false;
			}
		}

		/*while (tape1ContainsNumbers || tape2ContainsNumbers) {
			if ((numberTape1 <= numberTape2 && tape1ContainsNumbers) || !tape2ContainsNumbers) {
				// add number from tape1 to target tape
				if (firstRun) {
					print(target, numberTape1);
					firstRun = false;
				} else {
					print(target, " " + numberTape1);
				}
				if (!isEndOfInputFile(tape1)) {
					numberTape1 = readInt(tape1);
				} else {
					tape1ContainsNumbers = false;
				}
				continue;
			}

			if ((numberTape2 < numberTape1 && tape2ContainsNumbers) || !tape1ContainsNumbers) {
				// add number from tape 2 to the target tape
				if (firstRun) {
					print(target, numberTape2);
					firstRun = false;
				} else {
					print(target, " " + numberTape2);
				}
				if (!isEndOfInputFile(tape2)) {
					numberTape2 = readInt(tape2);
				} else {
					tape2ContainsNumbers = false;
				}
				continue;
			}

		}*/
		
		boolean tape1RunNotEmpty = true;
		boolean tape2RunNotEmpty = true;
		
		while (tape1ContainsNumbers || tape2ContainsNumbers) {
		if(!tape1RunNotEmpty && !tape2RunNotEmpty) {
			tape1RunNotEmpty = true;
			tape2RunNotEmpty = true;
		}
			
			
		if ((numberTape1 <= numberTape2 && tape1ContainsNumbers && tape1RunNotEmpty) || !tape2ContainsNumbers || (tape1RunNotEmpty && !tape2RunNotEmpty)) {
			// add number from tape1 to target tape
			if (firstRun) {
				print(target, numberTape1);
				firstRun = false;
			} else {
				print(target, " " + numberTape1);
			}
			if (!isEndOfInputFile(tape1)) {
				//numberTape1 = readInt(tape1);
				int buffer = readInt(tape1);
				if(buffer < numberTape1)
					tape1RunNotEmpty = false;
				numberTape1 = buffer;
				
			} else {
				tape1ContainsNumbers = false;
				tape1RunNotEmpty = false;
			}
			continue;
		}

		if ((numberTape2 < numberTape1 && tape2ContainsNumbers && tape2RunNotEmpty) || !tape1ContainsNumbers || (!tape1RunNotEmpty && tape2RunNotEmpty)) {
			// add number from tape 2 to the target tape
			if (firstRun) {
				print(target, numberTape2);
				firstRun = false;
			} else {
				print(target, " " + numberTape2);
			}
			if (!isEndOfInputFile(tape2)) {
				int buffer = readInt(tape2);
				if(buffer < numberTape2)
					tape2RunNotEmpty = false;
				numberTape2 = buffer;
			} else {
				tape2ContainsNumbers = false;
				tape2RunNotEmpty = false;
			}
			continue;
		}
		}

		closeInputFile(tape1);
		closeOutputFile(target);
		closeInputFile(tape2);
	}

}
