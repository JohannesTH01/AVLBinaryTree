package uebung03.HashTable;

import uebung02.QickSort.StatObject;

public interface SortInterface {
	public void sort (Comparable A[], StatObject so);   // Sortierverfahren mit 2. Objekt zum Sammeln von Statistikdaten
	public void sort (Comparable A[], StatObject so, int direction);   // Sortierverfahren mit 2. Objekt zum Sammeln von Statistikdaten
}
