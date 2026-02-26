package Topics.Tree;

import Daily.TreeNode;

public class LC1022 {

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(0);
        t.left.left = new TreeNode(0);
        t.left.right = new TreeNode(1);
        t.right = new TreeNode(1);
        t.right.right = new TreeNode(1);
        t.right.left = new TreeNode(0);
        System.out.println(sumRootToLeaf(t));
    }

    public static int sumRootToLeaf(TreeNode root) {

        return dfs(root,0);
    }

    public static int dfs(TreeNode root,int val){
        if(root==null)return 0;
        val =val<<1 |root.val;
        int left = dfs(root.left,val);
        int right = dfs(root.right,val);
        return root.left==root.right?val:left+right;
    }

}
