package Year26.Daily;

import Daily.TreeNode;

public class LC1123 {


    public static void main(String[] args) {

    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int l = height(root.left);
        int r = height(root.right);
        if(l==r) return root;
        if(l>r){
            return lcaDeepestLeaves(root.left);
        } else {
            return lcaDeepestLeaves(root.right);
        }
    }

    public int  height(TreeNode root){
        if(root==null) return 0;
        int l = height(root.left);
        int r = height(root.right);
        return 1+Math.max(l,r);
    }

    //Solution 2
    int deepest = 0;
    TreeNode lca = null;
    public TreeNode lcaDeepestLeaves0(TreeNode root) {
        helper(root,0);
        return lca;
    }

    private int helper(TreeNode node,int depth){
        deepest = Math.max(deepest,depth);
        if(node==null) return depth;
        int left = helper(node.left,depth+1);
        int right = helper(node.right,depth+1);
        if(left==deepest && right == deepest){
            lca = node;
        }
        return Math.max(left,right);
    }
}
