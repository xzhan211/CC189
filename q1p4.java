import java.util.*;
import java.lang.*;

public class q1p4{
    public static void main(String[] args){
        String test = "qqwertwerty";
        System.out.println(method(test));
        System.out.println(method2(test));
    }


    // T: O(n)
    // S: O(1)
    // A:
    public static boolean method(String test){
        int[] cnt = new int[26];
        for(char c : test.toCharArray()){
            cnt[c-'a']++;
        }
        boolean odd = false;
        for(int i : cnt){
            if(i%2 == 1 && odd == true)
                return false;
            else if(i%2 == 1)
                odd = true;
        }
        return true;
    }

    // T: O(n)
    // S: O(1) better
    // A:
    public static boolean method2(String test){
        int[] cnt = new int[26];
        int oddCounter = 0;
        for(char c : test.toCharArray()){
            cnt[c-'a']++;
            if(cnt[c-'a']%2 == 1)
                oddCounter++;
            else
                oddCounter--;
        }
        return oddCounter <= 1;
    }

    // We can also use bit vector, no need to count the real number,
    // just know the final answer is 0 or 1 that should be fine.
    // Bad thing is , it is not very straight forward.
}
