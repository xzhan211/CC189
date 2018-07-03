import java.util.*;
import java.lang.*;

public class q1p2{
    public static void main(String[] args){
        String test1 = "qwrrtyuiop";
        String test2 = "poiuytrewq";
        System.out.println(method1(test1, test2));
        System.out.println(method2(test1, test2));
    }

    // T: O(n)
    // S: O(n)
    // A: sort way, assumes letters only.
    // note: if assumes ASCII, know that ASCII from 0~127, it can be use
    // as index of array.
    public static boolean method1(String test1, String test2){
        if(test1.length() != test2.length())
            return false;
        char[] arr1 = test1.toCharArray();
        char[] arr2 = test2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for(int i = 0; i< arr1.length; i++){
            if(arr1[i] != arr2[i])
                return false;
        }
        return true;
    }

    // T: O(n)
    // S: O(n)
    // A: count character, assumes there only letters.
    public static boolean method2(String test1, String test2){
        if(test1.length() != test2.length())
            return false;
        int len = test1.length();
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for(int i = 0; i<len; i++){
            count1[test1.charAt(i)-'a']++;
            count2[test2.charAt(i)-'a']++;
        }
        for(int i = 0; i<26; i++){
            if(count1[i] != count2[i])
                return false;
        }
        return true;
    }
}
