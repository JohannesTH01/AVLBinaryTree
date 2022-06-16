package uebung03;

import org.junit.Test;

import uebung02.QickSort.StatObject;
import uebung03.Elements.StringElement;

public class Sorts1stTests {

    private void sort(Comparable[] iea, SortInterface sif, int sortDirection) {
        if (sortDirection < 0)
            sif.sort(iea, new StatObject(), sortDirection);
        else
            sif.sort(iea, new StatObject());

    }

    @Test
    public void testQuickSort() {
        StringElement[] iea = {
                new StringElement("abc"),
                new StringElement("abd"),
                new StringElement("abe"),
                new StringElement("abf"),
                new StringElement("abh"),
                new StringElement("abi")
        };
        

        sort(iea, new QuickSortV3(), -1);
    }

    @Test
    public void testInsertionSort() {
        StringElement[] iea = {
                new StringElement("abc"),
                new StringElement("abd"),
                new StringElement("abe"),
                new StringElement("abf"),
                new StringElement("abh"),
                new StringElement("abi")
        };

        sort(iea, new InsertionSort(), 1);
    }

}
