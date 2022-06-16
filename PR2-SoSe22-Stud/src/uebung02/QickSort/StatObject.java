package uebung02.QickSort;

public class StatObject {
	
	public int comparisonCounter;  // comparison counter = Zähler für Vergleiche                   
	private int swapCounter;  // swap counter       = Zahler für Vertauschungen                    
	private int runCounter;  // run counter        = Zahler für Durchläufe / Rekursionsschritte   
	
	public int incAndGetswapCounter () {return ++swapCounter;}
	public int incAndGetrunCounter () {return ++runCounter;}
	
	public int incAndGetcomparisonCounter () {return ++comparisonCounter;}	
	public int getcomparisonCounter () {return comparisonCounter;}
	
	public void inccomparisonCounter () {comparisonCounter++;}
	
	public int getswapCounter () {return swapCounter;}
	public int getrunCounter () {return runCounter;}
	
	public void incswapCounter () {swapCounter++;}
	public void incrunCounter () {runCounter++;}
	
	@Override
	public String toString() { // dient der Ausgabe von Statistik-Daten in print-Anweisungen
		return  "# Vergleiche: " + getcomparisonCounter()  + " # Vertauschungen: " + getswapCounter() + " # Durchläufe: " + getrunCounter();
	}


}
