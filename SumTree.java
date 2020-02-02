public class SumTree{
    public int sumTree(TreeNode node){
        if(node == null) return 0;
        int sum = node.val;
        sum += sumTree(node.left);
        sum += sumTree(node.right);
        return sum;
    }

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
            left = null;
            right = null;
        }
    }
}
