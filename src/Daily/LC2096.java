package Daily;

import java.util.ArrayList;
import java.util.List;

public class LC2096 {
    //If i solve this interview I might get confused need to sovle using this approach
    //https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/solutions/5484090/explanations-no-one-will-give-you-2-detailed-approaches-extremely-simple-and-effective/
    //Definition for a binary tree node.

      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }



    public static void main(String[] args) {
        TreeNode t = new TreeNode(5);
        t.left = new TreeNode(1);
        t.left.left = new TreeNode(3);
        t.right = new TreeNode(2);
        t.right.left = new TreeNode(6);
        t.right.right = new TreeNode(4);
        System.out.println(getDirections(t,3,6));

    }

    public static  String getDirections(TreeNode root, int startValue, int destValue) {
        List<String> pathToStart = new ArrayList<>();
        List<String> pathToDestination = new ArrayList<>();
        findPathFromRoot(root,startValue,pathToStart);
        findPathFromRoot(root,destValue,pathToDestination);
        int commonPath = 0;
        while(commonPath<pathToDestination.size() && commonPath<pathToStart.size() && pathToStart.get(commonPath).equals(pathToDestination.get(commonPath))){
            commonPath++;
        }
        List<String> res = new ArrayList<>();
        for(int i=commonPath;i<pathToStart.size();i++){
            res.add("U");
        }
        res.addAll(pathToDestination.subList(commonPath,pathToDestination.size()));
        return String.join("",res);
    }

    public static boolean findPathFromRoot(TreeNode root, int targetValue, List<String> pathToAppend){
      if(root==null) return false;
      if(root.val == targetValue) return true;

      pathToAppend.add("L");
      if(root.left!=null && findPathFromRoot(root.left,targetValue,pathToAppend)){
        return true;
      }
      pathToAppend.remove(pathToAppend.size()-1);

      pathToAppend.add("R");
      if(root.right!=null && findPathFromRoot(root.right,targetValue,pathToAppend)){
          return true;
      }
      pathToAppend.remove(pathToAppend.size()-1);

      return false;
    }









    /*
    Basically think of it like a minifying a tree to find the common point perfect algo and you should know it in your sleep
    if anythng is null we get rid of the whole thing
     */
    public static TreeNode lowestCommonAncestor(TreeNode root,int p,int q){
          //
          if(root==null || root.val==p ||root.val==q){
              return root;
          }
          TreeNode left = lowestCommonAncestor(root.left,p,q);
          TreeNode right = lowestCommonAncestor(root.right,p,q);
          //
          if(root.left!=null && root.right!=null) return root;
          return left!=null?left:right;
    }



}
