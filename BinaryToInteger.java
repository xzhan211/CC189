import java.util.*;
public class BinaryToInteger{
    public static void main(String[] args){
        String str = args[0];
        int ans = 0;
        for(int i=0; i<str.length(); i++){
            ans = (ans << 1) + (str.charAt(i)-'0');
        }
        System.out.println(ans);
    }
}
