import java.util.*;
import java.lang.*;
public class tree{
    public static void main(String[] args){
        int[] arr = {9,2,1,8,5,4,3,7,6,0};
        //int[] arr = {9,8,7,6,5,4,3,2,1,0};
        Node root;
        //root = buildBST(arr);
        root = buildBalanceTree(arr, 0, arr.length-1);
        preOrder(root);
        System.out.println("=======");
        inOrder(root);
        System.out.println("=======");
        postOrder(root);
        System.out.println("=======");
        bfsOrder(root);
        System.out.println("*******");
        System.out.println(getDepth(root)-1);
        System.out.println("+++++++");
        flip(root);
        bfsOrder(root);



    }

    public static Node buildBST(int[] arr){
        Node root = new Node(arr[0]);
        for(int i=1; i<arr.length; i++){
            Node temp = root;
            while(temp != null){
                if(arr[i] <= temp.val){
                    if(temp.left == null){
                        temp.left = new Node(arr[i]);
                        break;
                    }else
                        temp = temp.left;
                }else{
                    if(temp.right == null){
                        temp.right = new Node(arr[i]);
                        break;
                    }else
                        temp = temp.right;
                }
            }
        }
        return root;
    }

    public static Node buildBalanceTree(int[] arr, int lo, int hi){
        if(lo > hi) return null;
        int mid = lo + ((hi - lo) >> 1);
        Node root = new Node(arr[mid]);
        root.left = buildBalanceTree(arr, lo, mid-1);
        root.right = buildBalanceTree(arr, mid+1, hi);
        return root;
    }


    public static void preOrder(Node root){
        if(root == null) return;
        preOrder(root.left);
        System.out.println(root.val);
        preOrder(root.right);
    }

    public static void inOrder(Node root){
        if(root == null) return;
        System.out.println(root.val);
        inOrder(root.left);
        inOrder(root.right);
    }

    public static void postOrder(Node root){
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }

    public static void bfsOrder(Node root){
        LinkedList<Node> q = new LinkedList<>();
        q.offerFirst(root);
        while(q.size() != 0){
            Node temp = q.pollFirst();
            if(temp != null){
                q.offerLast(temp.left);
                q.offerLast(temp.right);
                System.out.println(temp.val);
            }else
                System.out.println("null");
        }
    }

    public static void flip(Node root){
        if(root == null) return;
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        flip(root.left);
        flip(root.right);
    }

    public static int getDepth(Node root){
        if(root == null) return 0;
        return Math.max(getDepth(root.left), getDepth(root.right))+1;
    }

}

class Node{
    int val;
    Node left;
    Node right;
    public Node(int val){
        this.val = val;
        left = null;
        right = null;
    }
}
