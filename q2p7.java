public class q2p7{
    public static void main(String[] args){
        Node head1 = new Node(3);
        head1.append(1);
        head1.append(5);
        head1.append(9);
        head1.append(7);
        head1.append(2);
        head1.append(1);
        Node head2 = new Node(4);
        head2.append(6);
        head2.next.next = head1.next.next.next;
        //------above is test case--------

        Node buf1 = head1;
        Node buf2 = head2;
        while(buf1 != buf2){
            if(buf1.next == null)
                buf1 = head2;
            else
                buf1 = buf1.next;
            if(buf2.next == null)
                buf2 = head1;
            else
                buf2 = buf2.next;
        }
        System.out.println("addr >> "+buf2 +"   value >> "+buf2.value);
    }
}
// T: O(n+m)
// S: O(1)
// A: another two way:
// one is get the length of these two linkedlist, then chop the different parts.
// when the two list have the same length, we can check the address of these two
// list. When two node share the same address, that is the answer.T: O(n), S:O(1)
// another one is using hashtree, save all the address in it, then compare each
// pair of node from back to front. T: O(n), S: O(n+m)
//
// Notice: we should compare the last nodes of these two list, if the address is
// not equal, that means no intersection
class Node{
    public Node next = null;
    public int value;
    public Node(int value){
        this.value = value;
    }
    public void append(int value){
        Node end = new Node(value);
        Node previous = this;
        while(previous.next != null){
            previous = previous.next;
        }
        previous.next = end;
    }
}
