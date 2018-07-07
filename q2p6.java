public class q2p6{
    public static void main(String[] args){
        Node head = new Node(1);
        head.append(2);
        head.append(3);
        head.append(4);
        head.append(3);
        head.append(2);
        head.append(1);
        Node newHead = head.reverse();
        Node buf = newHead;
        while(buf != null){
            System.out.println(buf.value);
            buf = buf.next;
        }
        System.out.println(compare(head, newHead));
    }
    public static boolean compare(Node A, Node B){
        while(A != null){
            if(A.value != B.value)
                return false;
            A = A.next;
            B = B.next;
        }
        return true;
    }
}
// T: O(n)
// S: O(n)
// A: another way, using stack, check first part and second part.
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

    public Node reverse(){
        Node oldHead = this;
        Node newHead = null;
        while(oldHead != null){
            Node rnode = new Node(oldHead.value);
            oldHead = oldHead.next;
            rnode.next = newHead;
            newHead = rnode;
        }
        return newHead;
    }
}
