import java.util.*;
public class q16p21{
    public static void main(String[] args){
        int[] inputA = {4,1,2,1,1,2};
        int[] inputB = {3,6,3,3};
        System.out.println(find(inputA, inputB));
    }
    // T: O(nm)
    // another way, b = a - target
    // and save b in hashset.
    //  T should be O(n+m)
    public static List<Integer> find(int[] inputA, int[] inputB){
        List<Integer> li = new ArrayList<>();
        int target = (sum(inputA) - sum(inputB)) / 2;
        for(int i = 0; i<inputA.length; i++){
            for(int j = 0; j<inputB.length; j++){
                if(inputA[i] - inputB[j] == target){
                    li.add(inputA[i]);
                    li.add(inputB[j]);
                    return li;
                }
            }
        }
        return li;
    }

    public static int sum(int[] arr){
        int ans = 0;
        for(int i : arr)
            ans += i;
        return ans;
    }

}
