import java.util.*;
import java.lang.*;

public class q1p6{
    public static void main(String[] args){
        String test = "aaaaaaaaaaaaacssscdfcccdddddsssaaadssscccdd";
        System.out.println(check(test));
    }

    // T: O(n)
    // S: O(n)
    // A: if StringBuilder was used, T should be O(n^2)
    public static String check(String str){
        StringBuffer sb = new StringBuffer();
        int cnt = 0;
        char buf = '\u0000';
        for(int i = 0; i<str.length(); i++){
            if(str.charAt(i) != buf){
                if(i != 0)
                    sb.append("" + buf+cnt);
                buf = str.charAt(i);
                cnt = 1;
            }else{
                cnt++;
            }
            if(i == str.length()-1){
                sb.append(""+buf+cnt);
            }
        }
        return new String(sb);
    }

}
