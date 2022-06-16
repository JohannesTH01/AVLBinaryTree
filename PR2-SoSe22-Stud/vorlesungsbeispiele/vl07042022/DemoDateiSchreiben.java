package vl07042022;

import static gdi.MakeItSimple.*;

public class DemoDateiSchreiben {

	public static void main(String[] args) {
		String filename = "VLOutput025.txt";
		println("sarting demo");

		if (isFilePresent (filename)) {
			println (filename+ " existiert schon ");
			return;
		}
		Object file = openOutputFile(filename);

			
		print(file, 1 + " ");
		print(file, 2);
		closeOutputFile(file);
 
	}

}
