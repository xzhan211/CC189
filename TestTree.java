public class TestTree{
    public static void main(String[] args){
        Tree tree = new Tree();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(1);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);
        System.out.println(tree.search(3));
        System.out.println(tree.search(8));
        System.out.println(tree.search(10));
        preorder(tree.getRoot());
        System.out.println("-------------");
        tree.delete(7);
        preorder(tree.getRoot());

    }
    public static void preorder(TreeNode root){
        if(root == null) return;
        System.out.println(root.num);
        preorder(root.left);
        preorder(root.right);
    }
}

/*
 * 比较合理的做法就是树节点和树的类分别遍历
 * 树不是数据结构，只是管理树节点结构的流程
 * 访问树的根节点，要通过树的对象访问根节点属性
 * tricky的地方就是创建树的时候 （new Tree()）是否需要创建根节点？
 * 我的做法是使用过Tree默认构造函数
 * 根节点的创建也交给insert method处处理， 只需要区分下根节点和普通节点就好
 * */

class Tree{
    // 对用户不暴露根节点
    private TreeNode root;

    public TreeNode getRoot(){
        return root;
    }

    public boolean search(int num){
        TreeNode node = root;
        while(node.left != null || node.right != null){
            if(node.num == num)
                return true;
            else if(node.num > num)
                node = node.left;
            else if(node.num < num)
                node = node.right;
        }
        if(node.num == num)
            return true;
        else
            return false;
    }

    public void insert(int num){
        TreeNode node = root;
        if(root != null){
            while(node.left != null || node.right != null){
                if(num <= node.num){
                    if(node.left == null){
                        node.left = new TreeNode(num);
                        return;
                    }else
                        node = node.left;
                }else{
                    if(node.right == null){
                        node.right = new TreeNode(num);
                        return;
                    }else
                        node = node.right;
                }
            }
            if(num <= node.num)
                node.left = new TreeNode(num);
            else
                node.right = new TreeNode(num);
            return;
        }else{
            root = new TreeNode(num);
            node = root;
        }
    }

    // 对用户不暴露根节点
    public void delete(int num){
        root = deleteRec(root, num);
    }

    /*
     * delete 不是删除节点， 而是删除节点中的值，然后哪更合适的值替换
     * 例如，如果删除根节点，没理由是把根节点的物理空间给删了把。。
     * 真正需要删除的节点，是找到目标节点后，再找到填补值的节点。
     * 此时填补值节点的值已经填充到目标删除节点的值上了，所以只需要删除填补值节点就好
     * */

    private TreeNode deleteRec(TreeNode node, int num){
        if(node == null) return node;
        if(num < node.num){
            node.left = deleteRec(node.left, num);
        }else if(num > node.num){
            node.right = deleteRec(node.right, num);
        }else{
            if(node.left == null)
                return node.right;
            else if(node.right == null)
                return node.left;
            //只做值替换，而不是删除这个节点再重新指定节点
            node.num = minValue(node.right);
            //上一步是替换值，下一步是删除多余节点，这步比较cool
            node.right = deleteRec(node.right, node.num);
        }
        return node;
    }
    /*
     * 在BST中找包含当前节点的最小值
     * 注意，最小值一定不可能出现在当前值的右子tree
     * */
    private int minValue(TreeNode node){
        int minv = node.num;
        while(node.left != null){
            minv = node.left.num;
            node = node.left;
        }
        return minv;
    }

}

class TreeNode{
    int num;
    TreeNode left;
    TreeNode right;

    public TreeNode(int num){
        this.num = num;
        left = null;
        right = null;
    }
}
