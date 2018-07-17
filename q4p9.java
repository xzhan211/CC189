import java.util.*;
import java.lang.*;
public class q4p9{
    public static void main(String[] args){
        int[] arr = {20,60,10,25,70};
        Node root = new Node(50);
        for(int n : arr){
            buildTree(root, n);
        }

        inNode(root);
        System.out.println("=============");

        ArrayList<LinkedList<Integer>> ans = allSequences(root);
        System.out.println(ans);


    }
    public static void inNode(Node root){
        if(root == null) return;
        inNode(root.left);
        System.out.println(root.value);
        inNode(root.right);
    }

    public static void buildTree(Node root, int value){
        if(root == null)
            return;
        if(value < root.value){
            if(root.left == null){
                root.left = new Node(value);
            }else{
                buildTree(root.left, value);
            }
        }else{
            if(root.right == null){
                root.right = new Node(value);
            }else{
                buildTree(root.right, value);
            }
        }
    }

    public static ArrayList<LinkedList<Integer>> allSequences(Node node){
        ArrayList<LinkedList<Integer>> result = new ArrayList<>();
        if(node == null){
            result.add(new LinkedList<Integer>());
            return result;
        }

        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(node.value);

        ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
        ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);

        for(LinkedList<Integer> left: leftSeq){
            for(LinkedList<Integer> right: rightSeq){
                ArrayList<LinkedList<Integer>> weaved = new ArrayList<>();
                weaveLists(left, right, weaved, prefix);
                result.addAll(weaved);
            }
        }
        return result;
    }

    public static void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second, ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix){
        if(first.size() == 0 || second.size() == 0){
            LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }

        int headFirst = (int) first.removeFirst();
        prefix.addLast(headFirst);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        first.addFirst(headFirst);


        int headSecond = (int) second.removeFirst();
        prefix.addLast(headSecond);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        second.addFirst(headSecond);
    }

}

class Node{
    int value;
    Node left = null;
    Node right = null;
    public Node(int value){
        this.value = value;
    }
}
