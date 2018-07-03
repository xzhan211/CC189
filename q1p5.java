import java.util.*;
import java.lang.*;

public class q1p5{
    public static void main(String[] args){
        String test1 = "bae";
        String test2 = "pale";
        System.out.println(check1(test1,test2));
    }


    // T: O(n) n is the shorter string's length
    // S: O(1)
    //
    public static boolean check1(String str1, String str2){
        int len1 = str1.length();
        int len2 = str2.length();
        if(Math.abs(len1-len2)>=2)
            return false;
        if(len1 == len2){
            return checkEqual(str1, str2);
        }else
            return checkUnequal(str1, str2);
    }

    public static boolean checkEqual(String str1, String str2){
        int len = str1.length();
        boolean flag = false;
        for(int i = 0; i<len; i++){
            if(str1.charAt(i) != str2.charAt(i) && flag == true)
                return false;
            if(str1.charAt(i) != str2.charAt(i))
                flag = true;
        }
        return true;
    }

    public static boolean checkUnequal(String str1, String str2){
        String longStr;
        String shortStr;
        if(str1.length() > str2.length()){
            longStr = str1;
            shortStr = str2;
        }else
            longStr = str2;
            shortStr = str1;
        boolean flag = false;
        int len = shortStr.length();
        for(int i = 0; i<len; i++){
            if(flag == true && shortStr.charAt(i) != longStr.charAt(i+1)){
                return false;
            }
            if(flag == false && shortStr.charAt(i) != longStr.charAt(i)){
                flag = true;
                i--;
            }
        }
        return true;
    }
}
