import java.util.*;
import java.lang.*;
public class q2p5{
    public static void main(String[] args){
        Node head1 = new Node(7);
        head1.append(1);
        head1.append(6);
        Node head2 = new Node(5);
        head2.append(9);
        head2.append(2);
        Node buf1 = head1;
        Node buf2 = head2;
        StringBuilder sb = new StringBuilder();
        while(buf1 != null){
            sb.append(buf1.value);
            buf1 = buf1.next;
        }
        String str1 = sb.reverse().toString();
        sb = new StringBuilder();
        while(buf2 != null){
            sb.append(buf2.value);
            buf2 = buf2.next;
        }
        String str2 = sb.reverse().toString();

        int sum = Integer.valueOf(str1) + Integer.valueOf(str2);

        String ans = ((Integer)sum).toString();
        char[] arrChar = ans.toCharArray();
        Node result = new Node(Integer.valueOf(arrChar[arrChar.length-1])-48);
        for(int i = arrChar.length-2; i>=0; i--){
                result.append(Integer.valueOf(arrChar[i])-48);
        }
        buf1 = result;
        while(buf1 != null){
            System.out.println(buf1.value);
            buf1 = buf1.next;
        }
    }

}


class Node{
    public Node next = null;
    public int value;
    public Node(int value){
        this.value = value;
    }
    public void append(int value){
       Node end = new Node(value);
       Node buf = this;
       while(buf.next != null){
           buf = buf.next;
       }
       buf.next = end;
    }
}
