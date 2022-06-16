package vl07042022;

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

public class SplitDemo {

	public static void main(String[] args) {

		pr.MakeItSimple.println("starting demo");
		print("tape_0= ");
		String tape_0 = readString();
		String tape_1 = "tape_1";
		String tape_2 = "tape_2";

		if (!isFilePresent(tape_0)) {
			println(tape_0 + " existiert nicht ");
			return;
		}
		Object tape0 = openInputFile(tape_0);
		Object tape1 = openOutputFile(tape_1);
		Object tape2 = openOutputFile(tape_2);

		boolean tape1b = true;
		int ll = 4;
		int cnt = 0;

		while (!isEndOfInputFile(tape0)) {
			
			if (tape1b) {
				print(tape1, readInt(tape0) + " ");
			}
			else
				print(tape2, readInt(tape0) + " ");
			
			cnt++;
			if (cnt % ll == 0) // wechsle Band
				tape1b = ! tape1b;
			
		}

//		readInt(file_i);

		closeInputFile(tape0);
		closeOutputFile(tape1);
		closeOutputFile(tape2);

	}

}
