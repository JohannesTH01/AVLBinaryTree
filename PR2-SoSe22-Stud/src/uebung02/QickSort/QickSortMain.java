package uebung02.QickSort;
import static gdi.MakeItSimple.*;

import java.lang.reflect.Array;
/**
 * @author Johannes , Julian ,Selin
 * @since 2022-04
 */
public class QickSortMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UI(); // calls UI method
	}
	private static void UI() { // UI method
		print("Welcome, please Enter the file to sort:"); // print welcome message
		String filePath = readLine(); // read the first line and save it to "filePath"
		while(!isFilePresent(filePath)) { // loop while File is not present
			println();
			//repeat to enter the filename
			print("File is not present please enter another one");
			filePath = readLine();
		}
		int[] arrayF = readFromFile(filePath); // add the file Data to array
		println();
		println("Which qicksort do you want to use?");
		print("qicksort variant 1 - v1 \nqicksort variant 2 - v2 \nqicksort variant 3 - v3 \nType in here: ");
		switch(readLine()) { // choose which sort to use
		case "v1": // runs the first Qicksort (V1)
			QuickSort sq = new QuickSort();
			/*@param array - array to sort
			* @param underLimit - first spot on the array
			* @param upperLimit - last spot on the array */
			sq.sort(arrayF,0, Array.getLength(arrayF));
		case "v2"://runs the second Qicksort (V2)
			QuickSortV2 sq2 = new QuickSortV2();
			sq2.sort(arrayF,0, Array.getLength(arrayF));
		case "v3": // runs the third Qicksort (V3)
			QuickSortV3 sq3 = new QuickSortV3();
			sq3.sort(arrayF,0, Array.getLength(arrayF));
		}
	}
	
	private static int[] readFromFile(String ipath) {
		Object in = openInputFile(ipath); // input file to get the length of for the array
		int[] array = new int[readLine(in).length()]; // add new array
		Object file = openInputFile(ipath); // open input file , read the ints out of this file
		for (int i = 0; i<array.length && !isEndOfInputFile(file); i++) { // for loop, to loop through the array
			array[i] = readInt(file);
		}
		closeInputFile(file); // close the opend input files
		closeInputFile(in);
		return array; // @return the array
		
	}

}
