public class q2p8{
    public static void main(String[] args){
        Node head1 = new Node(0);
        head1.append(1);
        head1.append(2);
        head1.append(3);
        head1.append(4);
        head1.append(5);
        head1.append(6);
        head1.append(7);
        head1.append(8);
        head1.append(9);
        head1.append(10);
        head1.append(11);
        head1.append(12);
        head1.last.next = head1.next.next.next.next.next;
        find(head1);
    }
    public static void find(Node head){
        Node fast = head;
        Node slow = head;
        do{
            fast = fast.next.next;
            slow = slow.next;
        }while(fast != slow);

        slow = head;

        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        System.out.println(slow.value);

    }
}
// T: O(n)
// S: O(1)
class Node{
    public Node next = null;
    public int value;
    public Node last = null;
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
        last = end;
    }
}
