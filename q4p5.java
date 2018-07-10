import java.lang.*;
import java.util.*;
public class q4p5{
    public static void main(String[] args){
        List<LinkedList> list = new ArrayList<>();
        LinkedList<Node> q = new LinkedList<>();
        int[] input  = {1,2,3,4,5,6,7,9,9,9,9,12,9,14,15,16};
        //int[] input  = {1,2,3,17,5,6,20,8,9,10,1,12,13,4,15,16};
        Node root = buildTree(input, 0, input.length-1);
        preOrder(root);
        System.out.println("+++++++++++++++++=");
        ArrayList<Integer> res = new ArrayList<>();
        inOrder(root, res);
        for(int i = 0; i< res.size()-1; i++){
            if(res.get(i)>res.get(i+1)){
                System.out.println("No BST");
                break;
            }
        }
        System.out.println("--end--");
        System.out.println(checkBST(root,null,null));
        //for(Integer i : res)
        //    System.out.println(i);
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
    // T:O(n)
    // S:O(n)
    public static void inOrder(Node root, ArrayList<Integer> res){
        if(root == null){
            return;
        }
        if(root.left != null){
            inOrder(root.left,res);
        }
        res.add(root.value);
        System.out.println(root.value);
        if(root.right != null){
            inOrder(root.right, res);
        }

    }

    // T:O(n)
    // S:O(logn)
    // A: this way is not straight forward.
    public static boolean checkBST(Node n,  Integer min, Integer max){
        if(n == null) return true; //triky
        if((min!=null && n.value<=min) || (max!=null && n.value>max))
            return false;
        if(!checkBST(n.left,min,n.value)||!checkBST(n.right, n.value,max))
            return false;
        return true;
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
