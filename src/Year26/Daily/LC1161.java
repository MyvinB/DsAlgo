package Year26.Daily;

import Daily.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LC1161 {


    public static void main(String[] args) {

    }

    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int idx =1;
        int max = Integer.MIN_VALUE;
        int maxlevel = 0;
        while(!queue.isEmpty()){
            int n = queue.size();
            int sum = 0;
            for(int i=0;i<n;i++){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
                sum+=node.val;
            }
            if(sum>max){
                maxlevel = idx;
                max = sum;
            }
            idx++;
        }
        return maxlevel;
    }
}
