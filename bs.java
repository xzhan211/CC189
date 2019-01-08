import java.util.*;
import java.lang.*;

public class bs{
    public static void main(String[] args){
        int[] arr = new int[]{1,4,5,9,12,17,19,20,22,25,27,30,33};
        int target = Integer.valueOf(args[0]);

        System.out.println("equal >> "+ bs1(arr, target));
        System.out.println("equal or minLarge >> "+ bs2(arr, target));
        System.out.println("equal or maxSmall >> "+ bs3(arr, target));

    }

    public static int bs1(int[] arr, int target){
        int lo = 0;
        int hi = arr.length-1;
        while(lo<=hi){
            int mid = lo + ((hi-lo)>>1);
            if(arr[mid] == target)
                return mid;
            else if(arr[mid] < target)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return -1;
    }

    public static int bs2(int[] arr, int target){
        int lo = 0;
        int hi = arr.length - 1;
        while(lo <= hi){
            int mid = lo + ((hi - lo)>>1);
            if(arr[mid] >= target)
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return lo < arr.length ? lo : -1;

    }

    public static int bs3(int[] arr, int target){
        int lo = 0;
        int hi = arr.length;
        while(lo <= hi){
            int mid = lo + ((hi - lo) >> 1);
            if(arr[mid] <= target)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return (hi<0 || lo>=arr.length) ? -1: hi;
    }
}
