import java.util.*;
import java.lang.*;
public class q8p9{
    public static void main(String[] args){
        String test = "((((()))))";
        permutation(test);
    }

    public static void permutation(String str){
        permutation(str, "");
    }


    // T: O(n!)
    // S: O(n!)
    // base on basic permutation algorithm
    // use check method implement the backtracking.
    public static void permutation(String str, String perfix){
        if(str.length() == 0){
            System.out.println(perfix);
            return;
        }

        for(int i = 0; i<str.length(); i++){
            if(i>0 && (str.charAt(i-1)==str.charAt(i))){
                continue;
            }
            String res = str.substring(0, i)+ str.substring(i+1);
            if(check(perfix))
                permutation(res, perfix+str.charAt(i));
        }

    }

    public static boolean check(String str){
        char[] arr = str.toCharArray();
        Stack<Character> stk = new Stack<>();
        for(Character c : arr){
            if(stk.empty())
                stk.push(c);
            else if(!stk.empty() && stk.peek() != c)
                stk.pop();
            else if(!stk.empty() && stk.peek() == c)
                stk.push(c);
        }
        return stk.search(')') == -1;
    }
}
