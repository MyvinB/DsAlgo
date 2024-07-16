package Daily;

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



//Need to check later
//    public static String getDirectionsSomethingWrong(TreeNode root, int startValue, int destValue) {
//        TreeNode lca = lowestCommonAncestor(root,startValue,destValue);
//        StringBuilder leftSide= new StringBuilder(),rightSide = new StringBuilder();
//        find(lca,startValue,leftSide);
//        find(lca,destValue,rightSide);
//        return "U".repeat(leftSide.length())+rightSide.reverse().toString();
//
//    }


    public static String getDirections(TreeNode root,int startValue,int destValue){
        StringBuilder leftSide= new StringBuilder(),rightSide = new StringBuilder();
        find(root,startValue,leftSide);
        find(root,destValue,rightSide);
        int i=0, max_i = Math.min(leftSide.length(),rightSide.length());
        while(i<max_i && leftSide.charAt(leftSide.length()-1-i) ==rightSide.charAt(rightSide.length()-1-i)) i++;

        return "U".repeat(leftSide.length()-i)+rightSide.reverse().toString().substring(i);
    }

    public static boolean find(TreeNode root, int targetValue, StringBuilder res){
          if(root.val==targetValue) return true;
          if(root.left!=null && find(root.left,targetValue,res)){
              res.append("L");
          }
          else if(root.right!=null && find(root.right,targetValue,res)){
              res.append("R");
          }
          return res.length()>0;
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
