import java.util.*;
public class q1p1{
    public static void main(String[] agrs){
        String testString = "qweratyuioplkjhgfdsazxcvbnm";
        boolean ans = false;
       // ans = hashSetWay(testString);
        ans = singleIntWay(testString);
        if(ans == false)
            System.out.println(false);
        else
            System.out.println(true);
    }

    // assumption: ASCII
    // time complexity: O(n)
    // space complexity: O(n)
    public static boolean hashSetWay(String testString){
        if(testString.length()>=128){
            return false;
        }
        Set<Character> hs = new HashSet<>();
        for(char c : testString.toCharArray()){
            if(!hs.add(c)){
                return false;
            }
        }
        return true;
    }

    // time complexity: O(n)
    // space complexity: O(1)
    public static boolean singleIntWay(String testString){
        if(testString.length()>=128){
            return false;
        }
        int checker = 0;
        for(int i = 0; i< testString.length(); i++){
            int buf = testString.charAt(i) - 'a';
            if((checker&(1<<buf))!=0){
                return false;
            }
            checker |= (1<<buf);
        }
        return true;
    }

    // if no other data structure can be use:
    // T: O(n^2), S: O(1)
    // T: O(nlgn) if we can sort the string. But sort algorithms usually
    // take more space.
}
