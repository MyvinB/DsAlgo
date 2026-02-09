package Year26.Daily;

import Daily.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC1382 {


    public static void main(String[] args) {

    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrderIterative(root,list);
        return createTreeFromInorderTraver(list,0,list.size()-1);
    }


    public void inOrderTraversal(TreeNode root, List<Integer> list){
        if(root==null) return ;
        inOrderTraversal(root.left,list);
        list.add(root.val);
        inOrderTraversal(root.right,list);
    }

    public TreeNode createTreeFromInorderTraver(List<Integer> list, int start, int end){

        if(start>end) return null;
        int mid = start + (end-start)/2;

        TreeNode left = createTreeFromInorderTraver(list,start,mid-1);
        TreeNode right = createTreeFromInorderTraver(list,mid+1,end);

        TreeNode node = new TreeNode(list.get(mid));
        node.left = left;
        node.right = right;

        return node;
    }

    public void inOrderIterative(TreeNode root, List<Integer> list){
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root!=null){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
    }
}
