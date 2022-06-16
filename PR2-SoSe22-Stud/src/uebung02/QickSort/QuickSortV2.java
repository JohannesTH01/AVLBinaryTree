package uebung02.QickSort;
import static gdi.MakeItSimple.*;
import static org.junit.Assert.assertArrayEquals;

/**
 * @author Johannes , Julian ,Selin
 * @since 2022-04
 */

public class QuickSortV2 implements SortInterface {
	
	StatObject so;
	
	public static void main(String args[]) {
		int array[] = new int[] {44,6,55,30,94,18,9,0};
		new QuickSortV2().sort(array, new StatObject());
		
		
		for(int i = 0; i < array.length; i++)
			print(array[i] + " ");
		

	}
	

	@Override
	public void sort(int[] F, int u, int o) {
		// TODO Auto-generated method stub
		if(o > u) {
			so.incrunCounter();
			int i = split(F, u, o);
			sort (F, u, i-1);
			sort (F, i+1, o);
		}
		
	}

	@Override
	public void sort(int[] F, StatObject so) {
		// TODO Auto-generated method stub
		this.so = so;
		sort(F, 0, F.length - 1);
	}

	@Override
	public int split(int[] F, int u, int o) {
		// TODO Auto-generated method stub
		int p = o;	//pivot is the last element within the range defined by u & o
		int piv = F[p];
		int l = p, r = u - 1;	//initial values
		while(u <= o) {
			boolean finish = false;	//flag for breaking the for-loops below
			l = p;
			r = u - 1;

			for(int i = u ; (i <= o && !finish); i++) {
				so.inccomparisonCounter();
				if(F[i] > piv) {	//if the current element is greater than the pivot, the index will be stored in "i" and the loop will be exited
					l = i;
					finish = true;
				}
			}
			finish = false;		//the flag is assigned its default value
			for(int i = (o - 1) ; (i >= u && !finish); i--){
				so.inccomparisonCounter();
				if(F[i] <= piv) {	//if the current element is smaller than the pivot or equal, the index will be stored in "i" and the loop will be exited
					r = i;
					finish = true;
				}	
			}
	
		if(l < r) {	

			swap(F, l, r);
			u = l + 1;
			o = r;
		}else {	//if l & r have crossed, p & l will be swaped

			swap(F, p, l);
			return l;
		}
			
		}
		
		//p & u will be swapped
		swap(F,p, u);
		return u;
	}

	@Override
	public void swap(int[] F, int i1, int i2) {
		// TODO Auto-generated method stub
		so.incswapCounter(); // count swap counter one up
		int remember = F[i1];
		F[i1] = F[i2];
		F[i2] = remember;
	}

}
