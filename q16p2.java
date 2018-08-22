import java.util.*;
public class q16p2{
    public static void main(String[] args){
        String[] str = {"cat", "cat", "dog", "bird", "cat", "mouse", "dog","fish"};
        Map<String, Integer> hm = new HashMap<>();
        count(str, hm);
        Set<String> keys = hm.keySet();
        for(String ss : keys){
            System.out.println(ss + " ::: "+ hm.get(ss));
        }
    }

    public static void count(String[] arr, Map<String, Integer> hm){
        for(String str : arr){
            hm.put(str, hm.getOrDefault(str, 0)+1);
        }
    }
}
