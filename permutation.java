import java.util.*;
class permutation{
    public static void main(String[] args){
        int[] arr = {1,2,3,4};
        List<List<Integer>> list = new ArrayList<>();
        int[] flag = new int[arr.length];
        getAll(arr, flag, list, new ArrayList<Integer>());
        for(List a: list){
            System.out.println(a);
        }
    }

    public static void getAll(int[] nums, int[] flag, List<List<Integer>> list, List<Integer> li){
        if(li.size() == nums.length){
            list.add(new ArrayList<Integer>(li));
            return;
        }

        for(int i = 0; i<nums.length; i++){
            if(flag[i] == 1)
                continue;
            li.add(nums[i]);
            flag[i] = 1;
            getAll(nums, flag, list,li);
            li.remove(li.size() - 1);
            flag[i] = 0;
        }


    }
}
