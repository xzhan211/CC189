import java.util.*;
public class MergeSortNew{
    public static void main(String[] args){
        int[] arr = {7,1,2,6,3,5,4,8,9,0};
        System.out.println(Arrays.toString(mergeSort(arr, 0, arr.length-1)));
    }

    public static int[] mergeSort(int[] arr, int lo, int hi){
        if(lo > hi) return null;
        else if(lo == hi) return arr;
        int mid = lo + ((hi - lo) >> 1);
        int[] arr1 = new int[mid - lo + 1];
        int[] arr2 = new int[hi - mid];
        int index = 0;
        for(int i=lo; i<=mid; i++)
            arr1[index++] = arr[i];
        index = 0;
        for(int i=mid+1; i<=hi; i++){
            arr2[index++] = arr[i];
        }
        int[] left = mergeSort(arr1, 0, arr1.length-1);
        int[] right = mergeSort(arr2, 0, arr2.length-1);
        return merge(left, right);
    }

    public static int[] merge(int[] left, int[] right){
        int[] total = new int[left.length + right.length];
        int r = 0;
        int l = 0;
        int t = 0;
        while(l < left.length || r < right.length){
            if(l < left.length && r < right.length){
                if(left[l]<=right[r])
                    total[t++] = left[l++];
                else
                    total[t++] = right[r++];
            }else if(l < left.length){
                total[t++] = left[l++];
            }else if(r < right.length){
                total[t++] = right[r++];
            }
        }
        return total;
    }
}
