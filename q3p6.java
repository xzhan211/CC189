import java.util.*;
public class q3p6{
    public static void main(String[] args){
        MyQueue<Character> mq = new MyQueue<>();
        mq.enqueue('c');
        mq.enqueue('d');
        mq.enqueue('d');
        mq.enqueue('c');
        mq.enqueue('c');
        mq.enqueue('c');
        mq.enqueue('c');
        mq.enqueue('d');
        mq.enqueue('c');
        mq.enqueue('c');
        System.out.println(mq.dequeueDog());
        System.out.println(mq.dequeueDog());
        System.out.println(mq.dequeueCat());
    }
}

class MyQueue<Character> extends LinkedList<Character>{
    public void enqueue(Character c){
        add(c);
    }

    public Character dequeueAny(){
        return removeLast();
    }

    public Character dequeueCat(){
        int pos = lastIndexOf('c');
        Character ans = get(pos);
        System.out.println(pos);
        remove(pos);
        return ans;
    }

    public Character dequeueDog(){
        int pos = lastIndexOf('d');
        Character ans = get(pos);
        System.out.println(pos);
        remove(pos);
        return ans;
    }
}
