package Topics.Tree;

import Daily.TreeNode;

public class LC110 {
    //Pretty obvious do not use static in the solution
    public static void main(String[] args) {
//        TreeNode t = new TreeNode(1);
//        t.left = new TreeNode(2);
//        t.left.left = new TreeNode(3);
//        t.left.left.left = new TreeNode(4);
//        t.right = new TreeNode(2);
//        t.left.right = new TreeNode(3);
//        t.left.left.right = new TreeNode(4);

        TreeNode t = new TreeNode(1);
        t.right = new TreeNode(2);
        t.right.right = new TreeNode(3);
        isBalanced(t);

    }
    static boolean isBalanced = true;
    public static boolean isBalanced(TreeNode root) {
        recurTree(root);
        return isBalanced;
    }

    public static int recurTree(TreeNode root){
        if(root==null) return -1;
        if(root.left==null && root.right==null) return 0;
        int left = 1+recurTree(root.left);
        int right = 1+recurTree(root.right);
        if(Math.abs(right-left)>1){
            isBalanced = false;
        }
        return Math.max(left,right);
    }


    public boolean isBalancedOpt(TreeNode root) {
        return dfsHeight(root) != -1;
    }

    public int dfsHeight(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = dfsHeight(root.left);
        if (leftHeight == -1) return -1; // Propagate error immediately

        int rightHeight = dfsHeight(root.right);
        if (rightHeight == -1) return -1; // Propagate error immediately

        if (Math.abs(leftHeight - rightHeight) > 1) return -1; // Found imbalance

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
