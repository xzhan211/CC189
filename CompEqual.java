import java.util.*;
public class CombEqual{
    public static void main(String[] args){
        int target = 5;
        int[] arr = {0,1,2,3,4,5};
        List<List<Integer>> ans = new ArrayList<>();
        find(target, arr, 0, ans, new ArrayList<Integer>());
        for(List li : ans){
            System.out.println(li);
        }
        System.out.println("==================");
        List<Integer> testList = new ArrayList<>();
        for(int i : arr){
            testList.add(i);
        }

        List<List<Integer>> testAns = new ArrayList<>();
        testAns.add(testList);
        List<Integer> testAnss = new ArrayList<>(testList);
        testList.add(9);
        System.out.println(testAns);
        System.out.println(testAnss);
    }

    public static void find(int target, int[] arr, int start, List<List<Integer>> ans, ArrayList<Integer> temp){
        int total = sum(temp);
        if(start > arr.length || total > target){
            return;
        }
        if(target == total){
            List<Integer> li = new ArrayList<>(temp);
            ans.add(li);
            return;
        }
        for(int i = start; i<arr.length; i++){
            temp.add(arr[i]);
            find(target, arr, i+1, ans, temp);
            temp.remove(temp.size()-1);
        }
    }

    public static int sum(List<Integer>temp){
        int total = 0;
        for(Integer i : temp){
            total += i;
        }
        return total;
    }
}
