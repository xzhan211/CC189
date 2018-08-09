import java.util.*;
public class q8p11{
    public static void main(String[] args){
        //sorted, easy to remove the duplication
        int[] test = {1,1,1,1,1,5,5,5,10,10,25,25};
        int target = 50;
        Set<List<Integer>> ans = new HashSet<>();
        check(ans, new ArrayList<Integer>(), test, target, 0);
        System.out.println(ans);
    }
    // T: less than O(2^n)
    // S: O(n^2)
    // Back tracking + recursion
    public static void check(Set<List<Integer>> list, List<Integer> li, int[] arr, int target, int start){
        if(start > arr.length) // tricky here. it is not arr.length-1
            return;
        if(sum(li) > target)
            return;
        if(sum(li) == target){
            list.add(new ArrayList<Integer>(li));
            return;
        }

        //all combination
        for(int i = start; i<arr.length; i++){
            li.add(arr[i]);
            check(list, li, arr, target, i+1);
            li.remove(li.size()-1);
        }
    }

    public static int sum(List<Integer> li){
        int ans = 0;
        for(Integer n: li)
            ans += n;
        return ans;
    }
}
