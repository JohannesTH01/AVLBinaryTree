package uebung03.HashTable;

public class StatObj {
	
	int cc;  // comparison counter = Zähler für Vergleiche
	int sc;  // swap counter       = Zahler für Vertauschungen
	int rc;  // run counter        = Zahler für Durchläufe / Rekursionsschritte
	
	int incAndGetcc () {return ++cc;}
	int incAndGetsc () {return ++sc;}
	int incAndGetrc () {return ++rc;}
	
	
	int getcc () {return cc;}
	int getsc () {return sc;}
	int getrc () {return rc;}
	
	void inccc () {cc++;}
	void incsc () {sc++;}
	void incrc () {rc++;}
	
	@Override
	public String toString() { // dient der Ausgabe von Statistik-Daten in print-Anweisungen
		return  " # Durchläufe: " + rc +  " # Vergleiche: " + cc + " # Vertauschungen: " + sc + "\n";
	}

}
