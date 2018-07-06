public class q2p4{
    public static void main(String[] args){
        Node head = new Node(0);
        int cnt = 1;
        while(cnt<=10){
            head.append(cnt++);
        }

        Node buf = head.change(head,6);

        while(buf != null){
            System.out.println(buf.value);
            buf = buf.next;
        }
    }
}

class Node{
    Node next = null;
    int value;
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
    public Node change(Node node, int x){
        Node head = node;
        Node tail = node;

        while(node != null){
            Node buf = node.next;
            if(node.value>=x){
                node.next = head;
                head = node;
            }else{
                tail.next = node;
                tail = node;
            }
            node = buf;
        }
        tail.next = null;
        return head;
    } //we must use return head here,
    //because we cannot modify the address value about the input parameter.
}
