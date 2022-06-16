package starterPackage;
import java.util.Scanner;

import uebung01.NatuerlicherMergeSort;
import uebung01.StraightMergeSort;

public class UI {
	
	
	public void menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the path of the file: ");
		String inputpath = sc.next();
		System.out.println("Enter the path of the outputfile: ");
		String outputpath = sc.next();
		System.out.println("Select one of the following algorithms: ");
		System.out.println("s - straigth");
		System.out.println("n - natural");
		char mode = sc.next().charAt(0);
		switch(mode) {
		case('s'):
			new StraightMergeSort().sort(inputpath, outputpath);
			break;
		case('n'):
			NatuerlicherMergeSort.natuerlicherMergeSort(inputpath, outputpath);
			break;
		default:
			System.out.println("Fehlerhafte eingabe.");
		}
	}
}
