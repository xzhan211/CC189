public class CheckSameTree{
    public static void main(String[] args){
        TreeNode root1 = null;//
        TreeNode root2 = null;//
        System.out.println(check(root1, root2));
    }
    public static boolean check(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null)
            return true;
        else if(node1 == null || node2 == null)
            return false;
        if(node1.val != node2.val)
            return false;
        return check(node1.left, node2.left) && check(node1.right, node2.right);

    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
    }
}
