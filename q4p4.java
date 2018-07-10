import java.lang.*;
import java.util.*;
public class q4p4{
    public static void main(String[] args){
        List<LinkedList> list = new ArrayList<>();
        LinkedList<Node> q = new LinkedList<>();
        int[] input  = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        Node root = buildTree(input, 0, input.length-1);
        preOrder(root);
        System.out.println("H >> " + checkHeight(root));
        int res = checkBalance(root);
        if(Integer.MIN_VALUE == res)
            System.out.println("No Banlance!!");
        else{
            System.out.println("Balance");
            System.out.println(res);
        }
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

    public static int  checkHeight(Node root){
        if(root == null) return -1; // why -1, leaf has no child.
        return Math.max(checkHeight(root.left), checkHeight(root.right))+1;
    }
    //T: O(n)
    //S: O(h) h is the tree height
    public static int checkBalance(Node root){
        int error = Integer.MIN_VALUE;
        if(root == null) return -1;
        int leftHeight = 0;
        int rightHeight = 0;
        leftHeight = checkBalance(root.left);
        if(leftHeight == error)
            return error;
        rightHeight = checkBalance(root.right);
        if(rightHeight == error)
            return error;
        if(Math.abs(leftHeight-rightHeight) > 1)
            return error;
        else
            return Math.max(leftHeight,rightHeight)+1;
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
