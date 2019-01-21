import java.util.*;

public class quicksort{
	public static void main(String[] args){
		int[] arr = {8,2,5,3,7,11,6,1,0,4,9,10};
		sort(arr, 0, arr.length-1);
		String str = Arrays.toString(arr);
		System.out.println(str);
	}

	public static int helper(int[] arr, int lo, int hi){
		int pivot = arr[hi];
		int i = lo-1;
		for(int j = lo; j<hi; j++){
			if(arr[j] <= pivot){
				i++;
				swap(arr, i, j);
			}
		}

		swap(arr, i+1, hi);
		return i+1;
	}

	public static void sort(int arr[], int lo, int hi){
		if(lo < hi){
			int pi = helper(arr, lo, hi);
			sort(arr, lo, pi-1);
			sort(arr, pi+1, hi);
		}

	}

	public static void swap(int[] arr, int m, int n){
		int temp = arr[m];
		arr[m] = arr[n];
		arr[n] = temp;
	}

}