import java.util.*;
import java.lang.*;
public class q4p9Sub{
    public static void main(String[] args){
        int[] A = {1,2,3,4};
        int[] B = {5,6,7};
        LinkedList<Integer>first = new LinkedList<Integer>();
        LinkedList<Integer>second = new LinkedList<Integer>();
        for(int i: A){
            first.add(i);
        }

        for(int i: B){
            second.add(i);
        }

        ArrayList<LinkedList<Integer>> ans = new ArrayList<>();
        weaved(first, second, ans, new LinkedList<Integer>());
        System.out.println(ans);

    }
    public static void  weaved(LinkedList<Integer> first, LinkedList<Integer> second, ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix){
        if(first.size()==0 || second.size()==0){
            LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }

        int headFirst = first.removeFirst();
        prefix.addLast(headFirst);
        weaved(first, second, results, prefix);
        prefix.removeLast();
        first.addFirst(headFirst);


        int headSecond = second.removeFirst();
        prefix.addLast(headSecond);
        weaved(first, second, results, prefix);
        prefix.removeLast();
        second.addFirst(headSecond);
    }
}
