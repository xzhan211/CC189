import java.util.*;
public class q10p0_sort{
    public static void main(String[] args){
        int[] test = {9,1,12,14,8,3,2,11,10,5,6,4,7,13};
        LinkedList<Integer> link = new LinkedList<>();
        for(int i: test){
            link.add(i);
            System.out.print(i+" ");
        }
        System.out.println("");

        //sort.bubble(test);
        //sort.selection(test);
        //link = sort.merge(link);
        //sort.quick(test);
        //sort.radix(test);
        //for(Integer i: link)
        //for(int i: test)
        //    System.out.print(i+" ");
        //System.out.println("");

        System.out.println(sort.buck(test));

    }
}

class sort{
    // T: O(n^2)
    // S: O(1)
    public static void bubble(int[] arr){
        for(int i = 0; i<arr.length; i++){
            for(int j = 0; j<arr.length-1-i; j++){
                if(arr[j] > arr[j+1])
                    swap(arr, j, j+1);
            }
        }
    }
    public static void swap(int[] arr, int a, int b){
        if(a != b){
            arr[a] = arr[a] + arr[b];
            arr[b] = arr[a] - arr[b];
            arr[a] = arr[a] - arr[b];
        }
    }

    /*-----------------------------------------------*/
    // T: O(n^2)
    // S: O(1)
    public static void selection(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int min = getMin(arr, i, arr.length);
            swap(arr, min, i);
        }
    }
    public static int getMin(int[] arr, int start, int len){
        int min = start;
        for(int i = start; i < len; i++){
            if(arr[i]< arr[min])
                min = i;
        }
        return min;
    }
    /*-----------------------------------------------*/

    // T: O(nlgn)
    // S: O(nlgn), can be reduced to O(n).
    // For merge algorithm, key point is as combine part.
    public static LinkedList<Integer> merge(LinkedList<Integer> link){
        int len = link.size();
        if(len>1){
            LinkedList<Integer> left = new LinkedList<>();
            LinkedList<Integer> right = new LinkedList<>();
            int mid = (len-1)/2;
            for(int i=0; i<len; i++){
                if(i<=mid)
                    left.add(link.get(i));
                else
                    right.add(link.get(i));
            }
            return combine(merge(left), merge(right));
        }
        return link;
    }

    public static LinkedList<Integer> combine(LinkedList<Integer> left, LinkedList<Integer> right){
        LinkedList<Integer> total = new LinkedList<>();
        while(left.size() != 0 && right.size() != 0){
            if(left.peek() <=  right.peek())
                total.add(left.pop());
            else
                total.add(right.pop());
        }
        while(left.size() != 0){
            total.add(left.pop());
        }
        while(right.size() != 0){
            total.add(right.pop());
        }
        return total;
    }

    /*-----------------------------------------------*/
    public static void quick(int[] arr){
        quick(arr, 0, arr.length-1);
    }

    public static void quick(int[] arr, int left, int right){
        int index = sort(left, right, arr);
        if(left < index -1)
            quick(arr, left, index-1);
        if(index < right)
            quick(arr, index, right);
    }
    // inline exchange, difficult to understand....
    public static int sort(int left, int right, int[] arr){
        int pivot = arr[(left+right)/2];
        while(left <= right){
            while(arr[left] < pivot)
                left++;
            while(arr[right] > pivot)
                right--;
            if(left <= right){
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return left;
    }
    /*-----------------------------------------------*/
    public static void radix(int[] arr){


    }


    /*-----------------------------------------------*/
    public static ArrayList<Integer> buck(int[] arr){
        int range = 20;
        int[] bucks = new int[20];
        Arrays.fill(bucks, 0);
        for(int i = 0; i<arr.length; i++){
            bucks[arr[i]]++;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i<bucks.length; i++){
            if(bucks[i] != 0){
                while(bucks[i] != 0){
                    ans.add(i);
                    bucks[i]--;
                }
            }
        }
        return ans;
    }

}
