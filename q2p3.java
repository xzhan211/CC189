public class q2p3{
    public static void main(String[] args){
        Node head = new Node(0);
        int cnt = 10;
        while(cnt > 0){
            head.append(cnt--);
        }

        Node buf = head;
        while(buf != null){
            System.out.println(">>"+ buf.value);
            buf = buf.next;
        }



        //head.removeMid();
        Node del = head.getNode(5);
        head.removeMid2(del);
        System.out.println("+++++++++++++++++++++++++++++++");
        buf = head;
        while(buf != null){
            System.out.println(">>"+ buf.value);
            buf = buf.next;
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
        Node previous = this;
        while(previous.next != null){
            previous = previous.next;
        }
        previous.next = end;
    }

    public Node getNode(int k){
        Node ans = this;
        int n = 0;
        while(ans != null){
            if(n++ == k)
                return ans;
            ans = ans.next;
        }
        System.out.println("no such index");
        return null;
    }



    //
    //
    // A: in this method, we know the head address before.
    public void removeMid(){
        Node ptr1 = this;
        Node ptr2 = this;
        Node pre1 = this;
        while(ptr2.next != null){
            if(ptr2.next == null)
                break;
            else if(ptr2.next.next == null){
                break;
            }
            ptr2 = ptr2.next.next;
            pre1 = ptr1;
            ptr1 = ptr1.next;
        }
        pre1.next = ptr1.next;
    }


    // T: O(1)
    // S: O(1)
    // A:
    public void removeMid2(Node pos){
        if(pos == null)
            return;
        if(pos.next == null){
            pos = null;
            return;
        }

        Node buf= pos.next;
        pos.value = buf.value;
        pos.next = buf.next;

    }
}
