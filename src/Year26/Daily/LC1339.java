package Year26.Daily;

import Daily.TreeNode;

public class LC1339 {


    public static void main(String[] args) {

    }

    public int maxProduct(TreeNode root) {
        int MOD = 1_000_000_007;
        int total = getTotal(root);
        long[] max = new long[]{Integer.MIN_VALUE};
        dfs(root,max,total);
        return (int)max[0]%MOD;
    }

    private long dfs(TreeNode root,long[] max,int total){
        if(root==null) return 0;
        long sum = root.val + dfs(root.left,max,total) + dfs(root.right,max,total);
        max[0] = Math.max(max[0],sum*(total-sum));
        return sum;
    }

    private int getTotal(TreeNode root){
        if(root==null) return 0;
        return root.val + getTotal(root.right) + getTotal(root.left);
    }
}
