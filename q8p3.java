import java.util.*;

public class q8p3{
    public static void main(String[] args){
        int[] test = {-14, 2, 2, 3, 4, 4, 8};
        ArrayList<Integer> ans = check(test);
        for(Integer n : ans){
            System.out.println(n);
        }
    }

    public static ArrayList<Integer> check(int[] arr){
        if(arr == null) return null;
        ArrayList<Integer> ans = new ArrayList<>();
        recursion(arr, 0, arr.length-1, ans);
        return ans;
    }

    public static void recursion(int[] arr, int start, int end, ArrayList<Integer> ans){
        if(end < start)
            return ;
        int mid = (start + end)/2;
        if(mid == arr[mid]){
            ans.add(mid);
        }
        //if(mid > arr[mid]){
            recursion(arr, mid+1, end, ans);
        //}else if(mid < arr[mid]){
            recursion(arr, start, mid-1, ans);
        //}
    }
}
