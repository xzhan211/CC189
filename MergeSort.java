import java.util.*;
public class MergeSort{
    public static void main(String[] args){
        int[] arr = {2,6,3,8,9,0,7,6,1,4,5};
        //key 1: 注意这里参数是数组长度
        ms(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void ms(int[] arr, int lo, int hi){
        //key 2: lo == hi-1时也要退出， 只剩一位数字，无需再分割
        if(lo+1 >= hi) return;
        //key 3: mid能出现的最大值就是[hi+(hi-2)]/2 = hi-1
        int mid = lo + ((hi-lo)>>1);
        //key 4: 范围永远是[a, b)半开区间
        ms(arr, lo, mid);
        ms(arr, mid, hi);
        merge(arr, lo, mid, hi);
    }

    public static void merge(int[] arr, int lo, int mid, int hi){
        //key 5: 因为是半开区间，最高位永远不用，类似substring范围定义
        int n1 = mid - lo;
        int n2 = hi - mid;
        int[] L = new int[n1+1];
        int[] R = new int[n2+1];
        for(int i = 0; i<n1; i++){
            L[i] = arr[lo+i];
        }
        for(int i = 0; i<n2; i++){
            R[i] = arr[mid+i];
        }
        // key6: 最高位用超大值表示，配合下面循环的次数，方便比较
        // 否则就要时刻判断index是否越界，笨方法
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;

        int l = 0;
        int r = 0;
        for(int k = lo; k<hi; k++){
            if(L[l]<=R[r]){
                arr[k] = L[l];
                l++;
            }else{
                arr[k] = R[r];
                r++;
            }
        }
    }
}
