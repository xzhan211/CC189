import java.util.*;
public class q4p3{
    public static void main(String[] args){
        List<LinkedList> list = new ArrayList<>();
        LinkedList<Node> q = new LinkedList<>();
        int[] input  = {1,2,3,4,5,6,7};
        Node root = buildTree(input, 0, input.length-1);
        preOrder(root);
        q.add(root);
        separate(list, q);
        System.out.println(list.size());
        // System.out.println(list.get(0).get(0));
        System.out.println(list.get(1).get(0));
        System.out.println(list.get(2).get(0));

    }
    public static Node buildTree(int[] arr, int start, int end){
        if(start > end) return null;
        int mid = (start + end)/2;
        Node root = new Node(arr[mid]);
        root.left = buildTree(arr, start, mid-1);
        root.right = buildTree(arr, mid+1, end);
        return root;
    }

    public static void preOrder(Node root){
        if(root == null){
            System.out.println("x");
            return;
        }
        System.out.println(root.value);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void separate(List<LinkedList> list, LinkedList<Node> q){
        LinkedList<Node> buf = new LinkedList<>();
        while(q.size()!=0){
            while(q.size() != 0){
                Node temp = q.removeFirst();
                if(temp.left != null) buf.add(temp.left);
                if(temp.right != null) buf.add(temp.right);
            }
            list.add(buf);
            while(buf.size()>0){
                q.add(buf.removeFirst());
            }
        }
    }
}

class Node{
    public int value;
    public Node left = null;
    public Node right = null;
    public Node(int value){
        this.value = value;
    }
}
