import java.util.*;
public class q8p7{
    public static void main(String[] args){
        String test = "abc";
        Permutation(test);
    }

    public static void Permutation(String str){
        Permutation(str, "");
    }
    public static void Permutation(String str, String prefix){
        if(str.length() == 0){
            System.out.println(prefix);
            return;
        }
        for(int i = 0; i < str.length(); i++){
            String res = str.substring(0, i)+str.substring(i+1);
            Permutation(res, prefix+str.charAt(i));
        }
    }

}
