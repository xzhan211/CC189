import java.util.*;
import java.lang.*;

// T: O(n)
// S: O(n)
// B: another way is using two pointers, just like brute force, T: O(n^2), S:O(1)

public class q2p1{
    public static void main(String[] args){
        Node head = new Node(1);
        Random rd = new Random();
        Set<Integer> hs = new HashSet<>();
        int n = 10;
        while(n>0){
            head.append(rd.nextInt(8));
            n--;
        }
        Node buffer = head;

        while(buffer.next !=null){
            System.out.println(buffer.value);
            buffer = buffer.next;
        }
        buffer = head;
        Node previous = null;
        while(buffer.next != null){
            if(!hs.add(buffer.value)){
                previous.next = buffer.next;
            }else{
                previous = buffer;
            }
            buffer = buffer.next;
        }
        buffer = head;
        while(buffer.next !=null){
            System.out.println(">> " + buffer.value);
            buffer = buffer.next;
        }
    }
}
class Node{
    int value;
    Node next = null;
    public Node(int n){
        value = n;
    }

    public void append(int n){
        Node end = new Node(n);
        Node k = this;
        while(k.next != null){
            k = k.next;
        }
        k.next = end;
    }
}
