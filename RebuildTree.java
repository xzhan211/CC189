import java.util.*;


public class RebuildTree{
    public static void main(String[] args){
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode root = dfs(0, pre, 0, in.length-1, in);
        preOrder(root);
    }

    public static void preOrder(TreeNode root){
        if(root == null) return;
        preOrder(root.left);
        System.out.println(root.val);
        preOrder(root.right);
    }

    public static TreeNode dfs(int pos, int[] pre, int lo, int hi, int[] in){
        if(pos == pre.length) return null;


        TreeNode node = new TreeNode(pre[pos]);
        int mid = -1;
        for(int i=lo; i<=hi; i++){
            if(in[i] == pre[pos])
                mid = i;
        }
        TreeNode left = null;
        if(mid-1 >= lo)
            left = dfs(pos+1, pre, lo, mid-1, in);

        TreeNode right = null;
        if(mid+1 <= hi)
            right = dfs(pos+mid-lo+1, pre, mid+1,hi, in);

        node.left = left;
        node.right = right;

        return node;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}
