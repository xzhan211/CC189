import java.util.*;
public class q10p2{
    public static void main(String[] args){
        String[] test = {"abcdcba", "asbe", "12344321", "qqqqa", "qwertyu","zazaaa","oiuyuio"};
        sort(test);
        for(String str : test){
            System.out.print(str+" ");
        }
        System.out.println(" ");
    }

    public static void sort(String[] arr){
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            while(check(arr[left]))
                left++;
            while(!check(arr[right]))
                right--;
            if(left <= right && left < arr.length && right > 0)
                swap(left, right, arr);
        }
    }

    public static void swap(int a, int b, String[] str){
        String buf = "";
        buf = str[a];
        str[a] = str[b];
        str[b] = buf;
    }

    public static boolean check(String str){
        int left = 0;
        int right = str.length()-1;
        while(left <= right){
            if(str.charAt(left) == str.charAt(right)){
                left++;
                right--;
            }else
                return false;
        }
        return true;
    }
}
