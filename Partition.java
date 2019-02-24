import java.util.*;
public class Partition{
    public static void main(String[] args){
        int[] arr = {1,0,2,9,3,8,4,7,4,5,6,3};
        int p = helper(arr, 0, arr.length-1);
        System.out.println(p);
        System.out.println(Arrays.toString(arr));
    }

    public static int helper(int[] arr, int lo, int hi){
        int pivot = arr[hi];
        int p = lo - 1;
        for(int i = lo; i<hi; i++){
            if(arr[i]<=pivot){
                p++;
                swap(arr, p, i);
            }
        }
        swap(arr, p+1, hi);
        return p+1;
    }

    public static void swap(int[] arr, int m, int n){
        int temp = arr[m];
        arr[m] = arr[n];
        arr[n] = temp;
    }
}
