import java.util.*;
public class PostOrder{
    public static void main(String[] args){
        int[] inputArr = {5,3,7,1,2,6,8,10,4,12,13};
        Tree tree = new Tree(inputArr[0]);
        for(int i=1;i<inputArr.length; i++){
            tree.insert(inputArr[i]);
        }
        System.out.println("===recursion===");
        tree.postOrder();
        System.out.println("");
        System.out.println("===iteration===");
        tree.postOrderIteration();
    }
}
class Tree{
    public Node root;
    public Tree(int val){
        root = new Node(val);
    }

    public void insert(int val){
        insert(root, val);
    }

    public void insert(Node node, int val){
        if(node == null) return;
        if(val <= node.val){
            if(node.left == null)
                node.left = new Node(val);
            else
                insert(node.left, val);
        }else{
            if(node.right == null)
                node.right = new Node(val);
            else
                insert(node.right, val);
        }
    }

    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.val);
    }

    /* the solution you need */
    public void postOrderIteration(){
        Stack<Node> leftStk = new Stack<>();
        Stack<Node> rightStk = new Stack<>();
        rightStk.push(root);
        Node cur = root;
        while(cur.left != null || cur.right != null || !leftStk.empty()){
            if(cur.right != null){
                rightStk.push(cur.right);
                if(cur.left != null)
                    leftStk.push(cur.left);
            }else{
                if(cur.left != null)
                    rightStk.push(cur.left);
                else
                    rightStk.push(leftStk.pop());
            }
            cur = rightStk.peek();
        }

        while(!rightStk.empty()){
            System.out.println(rightStk.pop().val);
        }
    }
}


class Node {
    int val;
    Node left;
    Node right;
    public Node(int val){
        this.val = val;
    }
}
