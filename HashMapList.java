import java.util.*;
public class HashMapList{
    public static void main(String[] args){
        HashMap<Integer, ArrayList<Character>> hml = new HashMap<>();
        ArrayList<Character> al = new ArrayList<>();
        al.add('a');
        al.add('b');
        hml.put(1, al);

        ArrayList<Character> al2 = new ArrayList<>();
        al2.add('c');
        al2.add('d');
        hml.put(2, al2);

        System.out.println(hml.get(1));
        System.out.println(hml.get(2));
    }
}
