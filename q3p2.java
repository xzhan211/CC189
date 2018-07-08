import java.util.*;
public class q3p2{
    public static void main(String[] args){
        MyStack stk = new MyStack();
        stk.myPush(10);
        stk.myPush(3);
        stk.myPush(1);
        stk.myPush(7);
        stk.myPush(2);
        stk.myPush(4);
        System.out.println(stk.min());


    }
}
// T: O(n)
// S: O(n)
// A: There is another way, get the elements to a array, and find the leasetest,
// return it.
class MyStack extends Stack<Integer>{
    Stack<Integer> s2;
    public MyStack(){
        s2 = new Stack<Integer>(); // dont forget generics
    }

    public void myPush(int value){
        if(value <= min())
            s2.push(value);
        push(value);
    }

    public int myPop(){
        int value = pop();
        if(value == min())
            s2.pop();
        return value;
    }

    public int min(){
        if(s2.empty())
            return Integer.MAX_VALUE;
        else
            return s2.peek();
    }

}
