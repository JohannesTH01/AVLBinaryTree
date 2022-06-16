package uebung02.QickSort;
import static gdi.MakeItSimple.*;

/**
 * @author Johannes , Julian ,Selin
 * @since 2022-04
 */

public class QuickSort implements SortInterface {
	StatObject so; // statistics collection

	@Override
	public void sort(int[] F, StatObject so) { // overloaded sort method for testing with parameters of an array and StatObject
		// TODO Auto-generated method stub
		this.so = so; // set StatObject to the attribute of itself
		sort(F, 0, F.length - 1); // call the normal sort method

	}

	@Override
	public void sort(int[] array, int lowerLimit, int upperLimit) {

		if(array.length <= 1) so.incrunCounter();

		if (upperLimit > lowerLimit) { // runs as long as the upper cabinets is greater than the under
			so.incrunCounter();// count runs for statistics
			//println("upperlimit is higher than lowerlimit");
			int splitIndex = split(array, lowerLimit, upperLimit); // call split method and write the index to splitIndex
			sort(array, lowerLimit, splitIndex); // call method recursive
			sort(array, (splitIndex + 1), upperLimit);
		}
	}

	@Override
	public int split(int[] array, int lowerLimit, int upperLimit) { // sorts elements in direction of the middle element
		// TODO Auto-generated method stub
		int pivotIndex = (lowerLimit + upperLimit) / 2; // set pivotIndex to the middle
		int pivot = array[pivotIndex]; // set middle element of the array to the pivot element



		while (lowerLimit <= upperLimit) { // run as long as upper is greater than lower


			// for loop loops as long as i is smaller than upperLimit +1 and the boolean found is false
			int l = lowerLimit;
			so.inccomparisonCounter();
			while(array[l] < pivot) {
				l++;
				if (array[l] <= pivot)
					so.inccomparisonCounter();
			}
			int r = upperLimit;
			so.inccomparisonCounter();
			while(array[r] > pivot) {
				r--;
				if(array[r] >= pivot)
					so.inccomparisonCounter(); // TODO abweichung um 1
			}


			if (l < r) {
				swap(array, r, l); // call swap method with array, r and l
				so.incswapCounter(); // count swaps
				lowerLimit = l + 1; // add one to l and write it in lowerLimit
				upperLimit = r - 1;
			} else {
				return r;
			}
		}

		for (int i : array) { // output after every run
			print(i + " ");
		}
		println();

		return upperLimit;
	}

	@Override
	public void swap(int[] array, int r, int l) { // swap elements of array
		// TODO Auto-generated method stub
		int temp = array[r]; // create temporary variable "temp"
		array[r] = array[l];
		array[l] = temp;
	}

}