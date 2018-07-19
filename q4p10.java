import java.lang.*;
import java.util.*;
public class q4p10{
    public static void main(String[] args){
        LinkedList<Node> llink = new LinkedList<>();
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        Node rootBig = BuildTree(null, arr, 0, new LinkedList<Node>());
        displayPreOrder(rootBig);
        System.out.println("-------------");
        int[] arrTest = {4,8,9};
        Node rootTest = BuildTree(null, arrTest, 0, new LinkedList<Node>());
        displayPreOrder(rootTest);
        System.out.println("=============");

        System.out.println(compString(rootBig, rootTest));
        System.out.println("*************");
        System.out.println(containsTree(rootBig, rootTest));
    }
    // T: O(n+m)
    // S: O(n+m)
    // Idea: using pre-order traveral. transfer tree to array, then compare
    // array.
    public static boolean compString(Node root1, Node root2){
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        preOrder(root1, sb1);
        preOrder(root2, sb2);
        return sb1.indexOf(sb2.toString()) != -1;
    }

    public static void preOrder(Node root, StringBuilder sb){
        if(root == null){
            sb.append("X");
            return;
        }
        sb.append(root.value+"");
        preOrder(root.left, sb);
        preOrder(root.right, sb);
    }

    public static void displayPreOrder(Node root){
        if(root == null)
            return;
        /*
        System.out.println("########");
        System.out.println(root.value);
        if(root.left != null)
            System.out.println(root.left);
        if(root.right != null)
            System.out.println(root.right);
        */

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


    //sol two
    //T: O(n+km)
    //S: O(logn+logm)


    public static boolean containsTree(Node n1, Node n2){
        if(n2 == null)
            return true;
        return subTree(n1,n2);
    }

    public static boolean subTree(Node n1, Node n2){
        if(n1 == null)
            return false;
        else if(n1.value == n2.value && match(n1, n2))
            return true;
        return subTree(n1.left, n2) || subTree(n1.right, n2);
    }

    public static boolean match(Node n1, Node n2){
        if(n1 == null && n2 == null)
            return true;
        else if(n1 == null || n2 == null)
            return false;
        else if(n1.value != n2.value)
            return false;
        else
            return match(n1.left, n2.left) && match(n1.right, n2.right);
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
