package uebung01;

public class MergeSort {
	
	public void naturalMergeSort(String inputfile, String outputfile) {
		NatuerlicherMergeSort.natuerlicherMergeSort(inputfile, outputfile);
	}
	
	public void straightMergeSort(String inputFile, String outputFile) {
		//direkterMergesort.direktMerge(inputfile, outputfile);
		DirekterMergesort dm = new DirekterMergesort();
		dm.runMergeSort(inputFile,outputFile);
	}

}
