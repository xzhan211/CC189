public class q4p8{
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        Node root = buildTree(arr, 0, arr.length-1, null);
        //inOrder(root);
        preOrder(root);

        Node testA = root.left.left.left;
        Node testB = root.left.right.right;

        System.out.println(">> "+ commonAncestor(testA, testB).value);
        System.out.println("++ "+ commonAncestorNew(root, testA, testB).value);
    }

    public static Node buildTree(int[] arr, int start, int end, Node n){
        if(start>end) return null;
        int mid = (start + end)/2;
        Node root = new Node(arr[mid], n);
        root.left = buildTree(arr, start, mid-1, root);
        root.right = buildTree(arr, mid+1, end,root);
        return root;
    }

    public static void inOrder(Node root){
        if(root == null) return;
        inOrder(root.left);
        System.out.println(root.value);
        inOrder(root.right);
    }

    public static void preOrder(Node root){
        if(root == null) return;
        System.out.println(root.value);
        preOrder(root.left);
        preOrder(root.right);
    }

    //T: O(n)
    //S: O(1)
    //A: there is no parent information in Node.
    public static Node commonAncestorNew(Node root, Node a, Node b){
        if(!covers(root, a)||!covers(root, b)){
            return null;
        }
        return ancestorHelper(root, a, b);
    }

    public static Node ancestorHelper (Node root, Node p, Node q){
        if(root == null || p == null || q == null){
            return root;
        }

        boolean pIsOnLeft = covers(root.left, p);
        boolean qIsOnLeft = covers(root.left, q);
        if(pIsOnLeft != qIsOnLeft){
            return root;
        }
        Node childSide = pIsOnLeft ? root.left:root.right;
        return ancestorHelper(childSide, p, q);
    }
    // good job
    public static boolean covers(Node root, Node a){
        if(root == null)return false;
        if(root == a) return true;
        return covers(root.left, a)||covers(root.right,a);

    }





    // T: O(n)
    // S: O(1)
    // A: just like linkedlist question, find intersection.
    // Assume there parent information in Node.
    public static Node commonAncestor(Node a, Node b){
        if(a == null || b == null)
            return null;
        Node lLen = getDepth(a) >= getDepth(b)? a:b;
        Node sLen = getDepth(a) >= getDepth(b)? b:a;
        int diff = getDepth(lLen) - getDepth(sLen);
        while(diff > 0){
            lLen = lLen.parent;
            diff--;
        }
        while(lLen != sLen && lLen != null && sLen != null){
            lLen = lLen.parent;
            sLen = sLen.parent;
        }
        return lLen;
    }

    public static int getDepth(Node a){
        if(a == null)
            return -1;
        int cnt = 0;
        while(a.parent != null){
            cnt++;
            a = a.parent;
        }
        return cnt;
    }
}

class Node{
    public int value;
    public Node parent = null;
    public Node left = null;
    public Node right = null;
    public Node(int value, Node parent){
        this.value = value;
        this.parent = parent;
    }
}
