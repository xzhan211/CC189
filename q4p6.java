import java.lang.*;
import java.util.*;
public class q4p6{
    public static void main(String[] args){
        List<LinkedList> list = new ArrayList<>();
        LinkedList<Node> q = new LinkedList<>();
        int[] input  = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        Node root = buildTree(input, 0, input.length-1, null);
        preOrder(root);
        System.out.println("+++++++++++++++++=");
        Node test = root.right;
        System.out.println("==  "+test.value);
        System.out.println(">>  "+inorderSucc(test).value);

    }

    public static Node buildTree(int[] arr, int start, int end, Node nd){
        if(start > end) return null;
        int mid = (start + end)/2;
        Node root = new Node(arr[mid], nd);
        root.left = buildTree(arr, start, mid-1, root);
        root.right = buildTree(arr, mid+1, end, root);
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
    public static boolean checkBST(Node n,  Integer min, Integer max){
        if(n == null) return true; //triky
        if((min!=null && n.value<=min) || (max!=null && n.value>max))
            return false;
        if(!checkBST(n.left,min,n.value)||!checkBST(n.right, n.value,max))
            return false;
        return true;
    }

    //T: O(n)
    //S: O(1)
    //Note: should understand traverse well.
    //Next step, which node to go.
    //
    public static Node inorderSucc(Node n){
        if(n == null)
            return null;
        if(n.left != null)
            return leftMostChild(n);
        else{
            Node q = n;
            Node x = q.parent;
            while(x!=null && x.left!=q){
                q = x;
                x = x.parent;
            }
            return x;
        }
    }

    public static Node leftMostChild(Node n){
        if(n == null)
            return null;
        while(n.left != null){//get last one, so use n.left determining.
            n = n.left;
        }
        return n;
    }
}

class Node{
    public int value;
    public Node left = null;
    public Node right = null;
    public Node parent = null;
    public Node(int value, Node parent){
        this.value = value;
        this.parent = parent;
    }
}
