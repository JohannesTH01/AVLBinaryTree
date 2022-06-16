package uebung03;

import uebung02.QickSort.StatObject;

import static gdi.MakeItSimple.print;
import static pr.MakeItSimple.println;

public class InsertionSort implements SortInterface {

    public static void sortArray(Comparable[] array, uebung03.SortInterface s, int direction) {
        s.sort(array, new StatObject(), direction);
    }

    @Override
    public void sort(Comparable[] F, StatObject so) {
        this.sort(F, so, 1); // with default direction 1
    }

    @Override
    public void sort(Comparable[] array, StatObject so, int direction) {
        for (int i = 1; i < array.length; i++) { // loop from 1 to array.length-1
            int j = i; // set j to i
            Comparable m = array[i]; // set one Comparible m to array at pos. i
            while (j > 0 && (array[j - 1].compareTo(m) * direction) < 0) { // checks the right order with compare to...
                array[j] = array[j - 1]; //set array j to array j-1
                j--; // decrement j
            }
            array[j] = m; // set array[j] with m
        }
    }
}
