import java.util.*;
public class q5p3{
    public static void main(String[] args){
        System.out.println("test >>" + Integer.BYTES);
        int input = 59230;
        System.out.println(check(input));
    }
    //T: O(b^2) b is bits of the input value
    //S: O(b)
    //A: brute force
    public static int check(int input){
        if(input == -1)
            return Integer.BYTES * 8;
        String str = Integer.toBinaryString(input);
        char[] arr = str.toCharArray();
        System.out.println("len >> "+ arr.length);
        int max = 0;
        int temp = 0;
        for(int i = 0; i< arr.length; i++){
            if(arr[i]== '0'){
                temp = count(i, arr.length, arr);
                if(max<temp)
                    max = temp;
            }
        }
        return max;
    }

    public static int count(int pos, int len, char[] arr){
        int ans = 1;
        for(int right = pos+1; right<len; right++){
            if(arr[right] == '0')
                break;
            if(arr[right] == '1')
                ans++;
        }
        for(int left = pos-1; left>=0; left--){
            if(arr[left] == '0')
                break;
            if(arr[left] == '1')
                ans++;
        }
        return ans;
    }
}
