import java.util.*;
public class QuickPick{
	public static void main(String[] args){
		int[] arr = {1,9,2,0, 6,5,3,1,9};
		int target = Integer.valueOf(args[0]);
		if(target <= 0 || target > arr.length)
			System.out.println("-1");
		else	
			System.out.println(qp(arr, 0, arr.length-1, target));
	}
	/*
		a b c d e f
		0 1 2 3 4 5
			p
			t
		temp(kth largest) = hi - p + 1	
		kth smallest = len - temp + 1;
	*/

	public static int qp(int[] arr, int lo, int hi, int target){
		int p = helper(arr, lo, hi);
		int temp = hi - p + 1;
		if(temp == target) return arr[p];
		else if(temp > target) return qp(arr, p+1, hi, target);
		else return qp(arr, lo, p-1, target-temp);
	}

	public static int helper(int[] arr, int lo, int hi){
		int pivot = arr[hi];
		int pos = lo - 1;
		for(int i = lo; i<hi; i++){
			if(arr[i]<=pivot){
				pos++;
				swap(arr, i, pos);
			}
		}
		swap(arr, pos+1, hi);
		//System.out.println(Arrays.toString(arr));
		//System.out.println(">> "+ (pos+1));
		return pos+1;
	}

	public static void swap(int[] arr, int n, int m){
		int temp = arr[n];
		arr[n] = arr[m];
		arr[m] = temp;
	}
}