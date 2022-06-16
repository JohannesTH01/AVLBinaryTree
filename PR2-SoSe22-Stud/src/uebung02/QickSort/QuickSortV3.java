package uebung02.QickSort;

import static gdi.MakeItSimple.*;

/**
 * @author Johannes , Julian ,Selin
 * @since 2022-04
 */

public class QuickSortV3 implements SortInterface {
	StatObject so;

	@Override
	public void sort(int[] F, StatObject so) { // overload method sort for testing
		// TODO Auto-generated method stub
		this.so = so;
		sort(F, 0, F.length - 1); // call the normal sort method this sort(int[] F, int u, int o)

	}

	@Override
	public void sort(int[] F, int u, int o) {
		if(F.length <= 1 ) so.incrunCounter();
		if (o > u) { // runs as long as the upper cabinets is greater than the under
			// count runs for statistics
			so.incrunCounter();
			int i = split(F, u, o);// call split method and write the index to i
			sort(F, u, i - 1); // set upper cabinets one down
			sort(F, i + 1, o); // set under cabinets one up
		}

	}

	// The split method is the main operation for the program, the parameters are
	// the Array and upper,under cabinets
	@Override
	public int split(int[] F, int u, int o) {
		// TODO Auto-generated method stub
		
		int p = o; // set the pivot element to the upper cabinets
		int index = u; // set index to under cabinets
		for (int zeiger = u; zeiger <= o - 1; zeiger++) {
			so.inccomparisonCounter(); // set comparisonCounter one up
			if (F[zeiger] <= F[p]) { // compare both elements

				println(F[index] + " " + F[zeiger]);
				if (zeiger != index) // swap only if the variables are not the same
					swap(F, index, zeiger); // the root array gets changed 
				index++; // increment index

			}
		}
		if (index != o) // swap only if index is not the same as the upper cabinets
			swap(F, index, p);

		for (int i : F) { // output after every run
			print(i + " ");
		}
		return index;
	}

	@Override
	public void swap(int[] F, int i1, int i2) { // swap method
		// TODO Auto-generated method stub
		so.incswapCounter(); // count swap counter one up
		int remember = F[i1];
		F[i1] = F[i2];
		F[i2] = remember;

	}

}
