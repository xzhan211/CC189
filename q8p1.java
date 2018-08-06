import java.util.*;
public class q8p1{
    static int  sum = 0;
    public static void main(String[] args){
        int input = 20;
        System.out.println("way 1 >>" + count(input));
        System.out.println("way 2 >>" + countWays(input));
        System.out.println("way 3 >>" + DP(input));
    }

    public static int count(int n){
        recursion(n, 0);
        return sum;
    }

    public static void recursion(int target, int cnt){
        if(cnt == target)
            sum++;
        if(cnt > target)
            return;
        recursion(target, cnt+1);
        recursion(target, cnt+2);
        recursion(target, cnt+3);
    }

    //better way: same logic
    //T: O(n^3)
    //S: O(n^3)
    public static int countWays(int n){
        if(n==0)
            return 1;
        if(n<0)
            return 0;
        return countWays(n-1)+countWays(n-2)+countWays(n-3);
    }

    //Dynamic Programming (top-down)
    //T: O(n)
    //S: O(n)
    public static int DP(int n){
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return countDP(n, memo);
    }

    public static int countDP(int target, int[] arr){
        if(target == 0)
            return 1;
        if(target < 0)
            return 0;
        if(arr[target] != -1)
            return arr[target];
        arr[target] = countDP(target-1, arr)+countDP(target-2, arr)+countDP(target-3,arr);
        return arr[target];
    }

}
