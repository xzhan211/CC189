import java.util.*;
import java.lang.Integer;
class q3p5{
    public static void main(String[] args){
        Stack<Integer> sk = new Stack<>();
        sk.push(2);
        sk.push(5);
        sk.push(1);
        sk.push(4);

        sort(sk);
        System.out.println(sk.peek());
    }
// T: O(n^2)
// S: O(n)
// A: other method: merge sort T:O(nlgn), S:O(nlgn)
//
// and quick sort: T:O(nlgn), S: O(n)
//  note: if no stack size limited.
//
//
    public static void sort(Stack<Integer> s){
        Stack<Integer> bufStk = new Stack<>();
        while(!s.empty()){
            int minValue = s.pop();
            while(!bufStk.empty() && (bufStk.peek()>minValue)){
                s.push(bufStk.pop());
            }
            bufStk.push(minValue);
        }
        while(!bufStk.empty()){
            s.push(bufStk.pop());
        }
    }
}
/*
class SortStack<Integer> extends Stack<Integer>{
    public boolean sort(){
        int aa = Integer.MAX_VALUE;  // error here, relate to Stack<Integer>
        return true;
    }
}
*/
