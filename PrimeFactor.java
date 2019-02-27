import java.util.*;
public class PrimeFactor{
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        int n = Integer.valueOf(args[0]);
        primeFactor(list, n);
        System.out.println(list.toString());
    }

    public static void primeFactor(List<Integer> list, int n){
        int c = 2;
        while(c*c <= n){
            if(n%c == 0){
                while(n%c == 0){
                    n /= c;
                }
                list.add(c);
            }
            c++;
        }
        if(n > 1 || list.size()==0)
            list.add(n);
    }
}
