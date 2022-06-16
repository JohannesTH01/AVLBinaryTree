package uebung02;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

import uebung02.QickSort.QuickSort;
import uebung02.QickSort.QuickSortV2;
import uebung02.QickSort.StatObject;

public class QuickSortTest {

	@Test
	public void quickSortTestV1_0() {
		int array[] = new int[] {44,6,55,30,94,18};
		new QuickSort().sort(array, new StatObject());
		
		
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		assertArrayEquals(new int[] {6,18,30,44,55,94}, array);
	}
	
	@Test
	public void quickSortTestV1_1() {
		int array[] = new int[] {44,6,55,30,94,18,22,1};
		new QuickSort().sort(array, new StatObject());
		
		
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		assertArrayEquals(new int[] {1,6,18,22,30,44,55,94}, array);
	}

	@Test
	public void quickSortTestV2_0() {
		int array[] = new int[] {44,6,55,30,94,18};
		new QuickSortV2().sort(array, new StatObject());
		
		
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		assertArrayEquals(new int[] {6,18,30,44,55,94}, array);
	}
	
	
}
