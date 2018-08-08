import java.util.*;
public class q8p4{
    public static void main(String[] args){
        int[] test = {1,2,3,4};
        List<List<Integer>> ans = new ArrayList<>();
        sub(ans, new ArrayList<Integer>(), test, 0);
        System.out.println(ans);
    }
    //T:O(2^n)
    //S:O(2^n)
    public static void sub(List<List<Integer>> list, List<Integer> li, int[] arr, int pos){
        list.add(new ArrayList<>(li));
        for(int i = pos; i<arr.length; i++){
            li.add(arr[i]);
            sub(list, li, arr, i+1);
            li.remove(li.size()-1);
        }
    }

}

    //way 2;
