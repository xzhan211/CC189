import java.lang.*;
import java.util.*;
public class q4p12{
    static int n;
    public static void main(String[] args){
        LinkedList<Node> llink = new LinkedList<>();
        int[] arr = {9,3,3,4,-2,-4,7,-4,7,-1,9,2};
        Node root = BuildTree(null, arr, 0, new LinkedList<Node>());
        displayPreOrder(root);
        System.out.println("-------------");
        cal(root, 0, 3);
        System.out.println(n);
    }

    public static void displayPreOrder(Node root){
        if(root == null)
            return;
        displayPreOrder(root.left);
        displayPreOrder(root.right);
    }
    //build tree line by line, should use queue structure
    public static Node BuildTree(Node root, int[] arr,int start,  LinkedList<Node> llink){
        if(start < arr.length){
            llink.addLast(new Node(arr[start]));
            if(llink.size()==1){
                root = llink.peekFirst();
            }
            if(llink.size() > 1){
                Node temp = llink.peekFirst();
                if(temp.left == null)
                    temp.left = llink.peekLast();
                else if(temp.right == null){
                    temp.right = llink.peekLast();
                    llink.removeFirst();
                }
            }
        }else
            return null;
        BuildTree(root, arr, ++start, llink);
        return root;
    }
    public static void cal(Node root, int sum, int target){
        if(root == null)
            return;
        if(sum > target)
            return;
        if(sum == target){
            n++;
            sum = 0;
            return;
        }
        sum = root.value + sum;
        cal(root.left, sum, target);
        cal(root.right,sum, target);


    }



}

class Node{
    Node right = null;
    Node left = null;
    int value;
    public Node(int value){
        this.value = value;
    }
}
