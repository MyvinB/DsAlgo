package Daily;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC1110 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
    }

    public  List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<Integer> toDelList = new ArrayList<>() ;
        List<TreeNode> res = new ArrayList<>();
        for(int i=0;i<to_delete.length;i++){
            toDelList.add(to_delete[i]);
        }
        dfs(root, toDelList,res);
        if(!toDelList.contains(root.val)){
            res.add(root);
        }
        return res;
    }


    public TreeNode dfs(TreeNode node, List<Integer> to_delete, List<TreeNode> treeNodeList){
        if(node==null) return null;

        node.left = dfs(node.left,to_delete,treeNodeList);
        node.right = dfs(node.right,to_delete,treeNodeList);

        if(to_delete.contains(node.val)){
            if(node.left!=null){
                treeNodeList.add(node.left);
            }
            if(node.right!=null){
                treeNodeList.add(node.right);
            }
            return null;
        }
        return node;
    }




    ///Bakwas soln coded by myself
    public void dfsOlder(TreeNode root, TreeNode parent, int left, List<Integer> to_delete, List<TreeNode> treeNodeList){
        if(root==null){
            return;
        }
        else if(to_delete.contains(root.val)){
            dfsOlder(root.left,null,-1,to_delete,treeNodeList);
            dfsOlder(root.right,null,-1,to_delete,treeNodeList);
            if(left==1 ){
                parent.left = null;
            }else if(left==0){
                parent.right = null;
            }
            return;

        }else if(parent==null){
            treeNodeList.add(root);
        }
        dfsOlder(root.left,root,1,to_delete,treeNodeList);
        dfsOlder(root.right,root,0,to_delete,treeNodeList);
    }
}
