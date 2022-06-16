package uebung03;

import uebung02.QickSort.StatObject;

import static gdi.MakeItSimple.*;

/**
 * @author Johannes , Julian ,Selin
 * @since 2022-04
 */

public class QuickSortV3 implements SortInterface {
    StatObject so;

    public static void sortArray(Comparable[] array, uebung03.SortInterface s, int direction) {
        s.sort(array, new StatObject(), direction);
    }

    @Override
    public void sort(Comparable[] F, StatObject so) { // overload method sort for testing
        this.so = so;
        sort(F, 0, F.length - 1, 1, so); // call the normal sort method this sort(int[] F, int u, int o)

    }

    public void sort(Comparable[] F, StatObject so, int Direction) {
        sort(F, 0, F.length - 1, Direction, so);
    }

    public void sort(Comparable[] F, int u, int o, int Direction, StatObject so) {
        if (F.length <= 1) so.incrunCounter();
        if (o > u) { // runs as long as the upper cabinets is greater than the under
            // count runs for statistics
            so.incrunCounter();
            int i = split(F, u, o, Direction, so);// call split method and write the index to i
            sort(F, u, i - 1, Direction, so); // set upper cabinets one down
            sort(F, i + 1, o, Direction, so); // set under cabinets one up
        }

    }

    // The split method is the main operation for the program, the parameters are
    // the Array and upper,under cabinets

    public int split(Comparable[] F, int u, int o, int Direction, StatObject so) {
        int p = o; // set the pivot element to the upper cabinets
        int index = u; // set index to under cabinets
        for (int zeiger = u; zeiger <= o - 1; zeiger++) {
            so.inccomparisonCounter(); // set comparisonCounter one up
            if ((F[zeiger].compareTo(F[p]) * Direction) >= 0) {

                if (zeiger != index) // swap only if the variables are not the same
                    swap(F, index, zeiger, so); // the root array gets changed
                index++; // increment index

            }
        }
        if (index != o) // swap only if index is not the same as the upper cabinets
            swap(F, index, p, so);


        return index;
    }

    public void swap(Comparable[] F, int i1, int i2, StatObject so) { // swap method
        so.incswapCounter(); // count swap counter one up
        Comparable remember = F[i1];
        F[i1] = F[i2];
        F[i2] = remember;

    }

}