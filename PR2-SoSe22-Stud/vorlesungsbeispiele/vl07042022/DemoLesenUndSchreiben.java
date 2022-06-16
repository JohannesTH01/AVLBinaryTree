package vl07042022;

import static gdi.MakeItSimple.*;


public class DemoLesenUndSchreiben {

	public static void main(String[] args) {
		String filename_i = "VLOutput02.txt";
		String filename_o = "VLOutput03.txt";
		println("sarting demo");

		if (!isFilePresent (filename_i)) {
			println (filename_i+ " existiert nicht ");
			return;
		}
		Object file_i = openInputFile(filename_i);
		Object file_o = openOutputFile(filename_o);

		while (!isEndOfInputFile(file_i)) {
			print(file_o, readInt(file_i) + " ");
		}
		
//		readInt(file_i);

		closeInputFile(file_i);
		closeOutputFile(file_o);
 
	}

}
