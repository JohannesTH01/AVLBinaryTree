/**
 * 
 */
package uebung02.QickSort;

/**
 * @author Johannes , Julian ,Selin
 * @since 2022-04
 */
public interface SortInterface {
	
	public void sort(int[] F , int u, int o); 
	public void sort(int[] F , StatObject so);
	public int split(int[] F , int u, int o); 
	public void swap(int[] F ,int i1 , int i2);

	
}
