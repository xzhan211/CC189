import java.util.*;
public class q16p20{
    public static void main(String[] args){
        int[][] test = {{1,2,3},{4,5,6},{7,8,9}};
        int[] inputA = {1,2,3};
        int[] inputB = {4,5,6};
        System.out.println(permutation(inputA, inputB).toString());
    }

    public static List<List<Integer>> permutation(int[] inputA, int[] inputB){
        List<List<Integer>> lists = new ArrayList<>();

        for(int i = 0; i<inputA.length; i++){
            for(int j = 0; j<inputB.length; j++){
                List<Integer> temp = new ArrayList<>();
                temp.add(inputA[i]);
                temp.add(inputB[j]);
                lists.add(temp);
            }
        }
        return lists;
    }

    void getValidWords(String number, int index, String prefix, HashSet<String> wordSet, ArrayList<String> results){
        if(index == number.length() && wordSet.contains(prefix)){
            results.add(prefix);
            return;
        }

        char digit = number.charAt(index);
        char[] letters = getT9Chars(digit);

        if(letters != nul){
            for(char letter: letters){
                getValidWords(number, index+1, prefix+letter, wordSet, results);
            }
        }
    }
}
