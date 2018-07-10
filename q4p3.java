import java.util.*;
public class q4p3{
    public static void main(String[] args){
        List<LinkedList> list = new ArrayList<>();
        LinkedList<Node> q = new LinkedList<>();
        int[] input  = {1,2,3,4,5,6,7};
        Node root = buildTree(input, 0, input.length-1);
        preOrder(root);
        //q.add(root);
        //separate(list, q);
        ArrayList<LinkedList<Node>> ans = separateTwo(root);
        System.out.println(ans.size());
        System.out.println(">> "+ans.get(0));
        System.out.println(">> "+ans.get(1));
        System.out.println(">> "+ans.get(2));
        //System.out.println(">> "+ans.get(3));
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
    //bad solution
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

    //good solution
    //A: below two comment lines are tricky. It doesnt work.
    //In lists, it stores list address, but it doesn't sotre the Node address
    //directly.
    //Then, list give its addres to temp.
    //In the inner while loop, when I remove elements from temp, that means I
    //indirectly remove the element in lists.
    //So, be careful. In array which contain other arrays,
    //make sure to understand what are stored in array!!!!!
    public static ArrayList<LinkedList<Node>> separateTwo(Node root){
        ArrayList<LinkedList<Node>> lists = new ArrayList<>();
        LinkedList<Node> list = new LinkedList<>();
        if(root != null)
            list.add(root);
        while(list.size()>0){
            lists.add(list);
            LinkedList<Node> temp = list;
            list = new LinkedList<Node>();
            for(Node nd: temp){ // much better way
            //while(temp.size()>0){
            //  Node nd = temp.removeFirst();  // very bad....
                System.out.println(nd);
                if(nd.left != null)
                    list.add(nd.left);
                if(nd.right != null)
                    list.add(nd.right);
            }
        }
        return lists;
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
