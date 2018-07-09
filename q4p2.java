public class q4p2{
    public static void main(String[] args){
        int[] input  = {1,2,3,4,5,6,7,8,9,10,11};
        Node root = buildTree(input, 0, input.length-1);
        preOrder(root);

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
}

class Node{
    public int value;
    public Node left = null;
    public Node right = null;
    public Node(int value){
        this.value = value;
    }
}
