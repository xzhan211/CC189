import java.util.*;
public class huffman{
    public static void main(String[] args){
        char[] chArr = {'a','b','c','d','e','f','g','h'};
        int[] freq = {10,20,30,5,8,16,40,2};
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i = 0; i<freq.length; i++){
            pq.offer(new Pair(chArr[i], freq[i]));
        }
        Pair root = null;
        while(pq.peek()!=null){
            Pair left = pq.poll();
            Pair right = null;
            if(pq.peek()!=null){
                right = pq.poll();
                root = new Pair('-', left.freq + right.freq);
                pq.offer(root);
                root.left = left;
                root.right = right;
            }else{
                root = left;
                break;
            }
        }
        check(root);

    }

    public static void check(Pair root){
        if(root == null) return;
        System.out.println("ch >> "+ root.ch + "  ::: freq >> " + root.freq);
        check(root.left);
        check(root.right);
    }


}

class Pair implements Comparable<Pair>{
    char ch;
    int freq;
    Pair right = null;
    Pair left = null;
    public Pair(char ch, int freq){
        this.ch = ch;
        this.freq = freq;
    }

    @Override
    public int compareTo(Pair p){
        return this.freq - p.freq;
    }
}
