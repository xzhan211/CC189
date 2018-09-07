import java.util.*;
public class q16p24{
    public static void main(String[] args){
        int[] input = {1,2,3,4,4,4,5,5,5,5,6,6,7,7,7,8,8,8,9,9,9,10};
        ArrayList<Pair> al = new ArrayList<>();
        ArrayList<Pair> al2 = new ArrayList<>();
        ArrayList<Pair> al3 = new ArrayList<>();
        findPair(input, al, 10);
        System.out.println(al);
        System.out.println("=========");
        findPair2(input, al2, 10);
        System.out.println(al2);
        System.out.println("=========");
        findPair3(input, al3, 10);
        System.out.println(al3);



    }
    //T:O(n^n)
    static void findPair(int[] input, List<Pair> al, int target){
        int len = input.length;
        for(int i = 0; i<len; i++){
            if(i>0 && input[i]==input[i-1])
                continue;
            for(int j = i+1; j<len; j++){
                if(j>i+1 && input[j]==input[j-1])
                    continue;
                if(input[i]+input[j]==target){
                    System.out.println("haha");
                    al.add(new Pair(input[i],input[j]));
                }
            }
        }
    }

    //T: O(n)+Q(nln) sort
    //S: O(n)OB
    static void findPair2(int[] input, List<Pair> al, int target){
        int len = input.length;
        HashSet<Integer> hs = new HashSet<>();
        for(int n : input)
            hs.add(n);
        for(int i = 0; i<len; i++){
            if(i>0 && input[i]==input[i-1])
                continue;
            if(hs.contains(target-input[i])){
                al.add(new Pair(input[i], target-input[i]));
                hs.remove(input[i]);
            }
        }
    }

    //another sol
    //no need sort, O(n)
    static void findPair3(int[] input, List<Pair> al, int target){
        HashMap<Integer, Integer> unpairedCount = new HashMap<>();
        for(int x: input){
            int complement = target - x;
            if(unpairedCount.getOrDefault(complement, 0)>0){
                al.add(new Pair(x, complement));
                adjustCounterBy(unpairedCount, complement, -100);
            }else{
                adjustCounterBy(unpairedCount, x, 1);
            }
        }
    }

    static void adjustCounterBy(HashMap<Integer, Integer> counter, int key, int delta){
            counter.put(key, counter.getOrDefault(key,0)+delta);
    }





}

class Pair{
    int first = 0;
    int second = 0;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
    @Override
    public String toString(){
        return "("+first+","+second+")";
    }
}
