import java.util.*;
public class q3p4{
    public static void main(String[] args){
        MyQueue<Character> mq = new MyQueue<>();
        mq.myPush('a');
        mq.myPush('b');
        mq.myPush('c');
        mq.myPush('d');
        mq.myPush('e');
        mq.myPush('f');
        System.out.println("size >> "+ mq.mySize());
        System.out.println("peek >> "+ mq.myPeek());
        System.out.println("empty >> "+ mq.myEmpty());
        System.out.println("pop >> "+ mq.myPop());
        System.out.println("pop >> "+ mq.myPop());
        System.out.println("peek >> "+ mq.myPeek());
        System.out.println("size >> "+ mq.mySize());
    }
}

// 1. understand how to write generic when inheriting from father class.
// 2. use the original method from Stack to create new method in my Stack.
// 3. using exception should be better.

class MyQueue<T> extends Stack<T>{
    public Stack<T> stackNew, stackOld;
    public MyQueue(){
        stackNew = new Stack<T>();
        stackOld = new Stack<T>();
    }

    public int mySize(){
        return stackNew.size() + stackOld.size();
    }

    public boolean shift(){
        if(!stackOld.empty())
            return false;
        while(!stackNew.empty()){
            stackOld.push(stackNew.pop());
        }
        return true;
    }

    public void myPush(T value){
        stackNew.push(value);
    }

    public T myPop(){
        if(stackOld.empty())
            shift();
        return stackOld.pop();
    }

    public boolean myEmpty(){
        if(stackOld.empty() && stackOld.empty())
            return true;
        return false;
    }

    public T myPeek(){
        if(stackOld.empty())
            shift();
        return stackOld.peek();
    }
}
