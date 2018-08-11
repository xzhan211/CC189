import java.util.*;
public class q10p2_1{
    public static void main(String[] args){
        String[] test = {"1234", "3214", "abc", "d", "bca", "4321", "bac", "d"};
        Arrays.sort(test, new AnagramComparator());
        //sort(T[] a, Comparator<? super T> c)
        for(String str : test){
            System.out.println(str);
        }
    }
/*
    public static void sort2(String[] array){
        HashMapList<String, String> mapList = new HashMapList<>();
        for(String s: array){
            String key = sortChars(s);
            mapList.put(key, s);
        }
        int index = 0;
        for(String key : mapList.keySet()){
            ArrayList<String> list = mapList.get(key);
            for(String t: list){
                array[index] = t;
                index++;
            }
        }
    }

    public static String sortChars(String s){
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

*/
}
//sort function in Arrays class bases on special comparator
class AnagramComparator implements Comparator<String>{
    public String sortChars(String s){
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
    @Override
    public int compare(String s1, String s2){
        return sortChars(s1).compareTo(sortChars(s2));
    }
}
