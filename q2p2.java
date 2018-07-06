public class q2p2{
    public static void main(String[] args){
        Node head = new Node(20);
        int cnt = 10;
        while(cnt > 0){
            head.append(cnt--);
        }
        Node buf = head;
        while(buf != null){
            System.out.println(buf.value);
            buf = buf.next;
        }
        head.kth(3);
        System.out.println("total k time >>"+ head.kthRecursion(head, 3));
    }

}

class Node{
    public  Node next = null;
    public int value;
    public Node(int value){
        this.value = value;
    }

    public void append(int value){
        Node end = new Node(value);
        end.value = value;
        Node previous = this;
        while(previous.next != null){
            previous = previous.next;
        }
        previous.next = end;
    }

    public void kth(int k){
        Node current = this;
        while(current != null){
            if(k<=0)
                System.out.println("element >> "+current.value);
            current = current.next;
            k--;
        }
    }


    // T: O(n)
    // S: O(1)
    // A: if using brute force, T:(2n), first n is using for find the length of
    // list.
    // The bad thing is, we can not use this method to return value.
    // Another better way is using k-width window, two pointers.
    public int kthRecursion(Node head, int k){
        if(head == null)
            return 0;
        int index = kthRecursion(head.next, k)+1;
        if(index == k)
            System.out.println(k+"th to last node is"+head.value);
        return index;
    }
}
