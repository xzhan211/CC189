public class q10p10{
    static Node root = null;
    public static void main(String[] args){
        int[] arr = {5,1,4,4,5,9,7,13,3};
        for(int a : arr){
            buildBST(a);
        }
        //System.out.println(root);
        System.out.println(root.rank(10));
    }
    public static void buildBST(int num){
        if(root == null)
            root = new Node(num);
        else
            root.insert(num);
        System.out.println(">> "+ root);

    }
}

class Node{
    int leftSize = 0;
    int value = 0;
    Node left, right;
    public Node(int value){
        this.value = value;
    }
    public int rank(int num){
        if(num == value)
            return leftSize;
        else if(num < value){
            if(left == null)
                return -1;
            else
                return left.rank(num);
        }else{
            int temp = right == null ? -1 : right.rank(num);
            if(temp == -1) return -1;
            else return leftSize + 1 + temp;
        }
    }

    public void insert(int num){
        if(num <= value){
            if(left == null)
                left = new Node(num);
            else
                left.insert(num);
            this.leftSize++;
        }else{
            if(right == null)
                right = new Node(num);
            else
                right.insert(num);
        }
    }
}
