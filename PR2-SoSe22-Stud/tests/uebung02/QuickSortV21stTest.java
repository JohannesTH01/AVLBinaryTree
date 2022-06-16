package uebung02;


import uebung02.QickSort.QuickSortV2;
import uebung02.QickSort.SortInterface;
import uebung02.QickSort.StatObject;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.lang.invoke.MethodHandles;

public class QuickSortV21stTest {

    int[] F1;
    int[] F2;
    int[] F3;


    StatObject so;

    @Before
    public void prepareTest() {
        F1 = new int[]{10, 4, 33, 44, 17, 20, 3, 2, 9, 82, 38, 67, 55, 11, 32, 23, 19, 7, 6, 14, 29}; // zufälliges
        // Feld
        F2 = new int[]{10, 4, 33, 44, 17, 20, 3, 2, 9, 82, 38, 67, 55, 11, 32, 23, 19, 7, 6, 14, 29, 10, 10}; // zufälliges
        // Feld
        // mit
        // Duplikaten
        F3 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // F ist schon sortiert;
    }

    @Test
    public void testQuick21() {   // QuickSort Variante 2
        SortInterface sm = new QuickSortV2();

        so = new StatObject();
        sm.sort(F1, so);
        assertThat(F1, is(new int[]{2, 3, 4, 6, 7, 9, 10, 11, 14, 17, 19, 20, 23, 29, 32, 33, 38, 44, 55, 67, 82}));
        assertEquals(89, so.getcomparisonCounter());
        assertEquals(21, so.getswapCounter());
        assertEquals(14, so.getrunCounter());

        so = new StatObject();
        sm.sort(F2, so);
        assertThat(F2, is(new int[]{2, 3, 4, 6, 7, 9, 10, 10, 10, 11, 14, 17, 19, 20, 23, 29, 32, 33, 38, 44, 55, 67, 82}));
        assertEquals(119, so.getcomparisonCounter());
        assertEquals(24, so.getswapCounter());
        assertEquals(18, so.getrunCounter());

        so = new StatObject();
        sm.sort(F3, so);
        assertThat(F3, is(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
        assertEquals(54, so.getcomparisonCounter());
        assertEquals(0, so.getswapCounter());
        assertEquals(9, so.getrunCounter());
    }

}
