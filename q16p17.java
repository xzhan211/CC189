import java.util.*;
public class q16p17{
    static int sum = 0;
    public static void main(String[] args){
        int[] input = {2,-8,3,-2,4,-10};
        seqSum(input,0,new ArrayList<Integer>());
        System.out.println(">> "+sum);
        System.out.println("new >> "+ getMaxSum(input));
    }

    //brute force
    //T: O(n^n)
    //S: O(1)
    public static void seqSum(int[] arr, int start, List<Integer> list){
        if(start >= arr.length){
            list.clear();
            return;
        }
        list.add(arr[start]);
        int temp = total(list);
        if(temp>sum)
            sum = temp;
        for(int i = start; i<arr.length; i++){
            seqSum(arr, i+1, list);
        }
    }

    public static int total(List<Integer> list){
        int temp = 0;
        for(Integer n : list)
            temp += n;
        return temp;
    }

    public static int getMaxSum(int[] a){
        int maxsum = 0;
        int sum = 0;
        for(int i = 0; i<a.length; i++){
            sum += a[i];
            if(maxsum<sum){
                maxsum = sum;
            }else if(sum < 0){
                sum = 0;
            }
        }
        return maxsum;
    }
}
