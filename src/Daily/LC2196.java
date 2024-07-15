package Daily;

import java.util.*;

public class LC2196 {

    //Definition for a binary tree node.
      public class TreeNode {
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

    }


//    15,17,20,80,19
//            20->{{15,1},{17,0}}
//50->{{20,1},{80,0}}
//80->{19,1}
//
//    //not naive but still could code better kudos to accepted code
    public TreeNode createBinaryTreeCoded(int[][] descriptions) {
        HashSet<Integer> children = new HashSet<>();
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        //Build the map
        for(int[] d :descriptions){
            int parent = d[0];
            int child = d[1];
            int dir = d[2];
            children.add(child);
            List<int[]> childList = map.getOrDefault(parent,new ArrayList<>());
            childList.add(new int[]{child,dir});
            map.put(parent,childList);
        }
        int parent = 0;
        //FInd the parent
        for(int i:map.keySet()){
            if(!children.contains(i)){
                parent = i;
                break;
            }
        }
        //Build the tree bfs or dfs doing bfs now

        TreeNode  node = new TreeNode(parent);
        queue.add(node);
        while(!queue.isEmpty()){
            TreeNode parentNode = queue.poll();
            if(map.containsKey(parentNode.val)){
                List<int[]> childList = map.get(parentNode.val);
                for(int[] c:childList){
                    int child = c[0];
                    int dir = c[1];
                    TreeNode childNode = new TreeNode(child);
                    queue.add(childNode);
                    if(dir==1){
                        parentNode.left = childNode;
                    }
                    else {
                        parentNode.right = childNode;
                    }
                }
            }
        }
        return node;
    }


    public TreeNode createBinaryTree(int[][] descriptions) {
        HashSet<Integer> children = new HashSet<>();
        HashMap<Integer, TreeNode> map = new HashMap<>();
        for(int[] d:descriptions){
            int parent = d[0],child= d[1],dir=d[2];
            children.add(child);
            TreeNode node = map.getOrDefault(parent,map.getOrDefault(parent,new TreeNode(parent)));
            if(dir==1){
                node.left = map.getOrDefault(child,new TreeNode(child));
                map.put(child,node.left);
            }
            else{
                node.right = map.getOrDefault(child,new TreeNode(child));
                map.put(child,node.right);
            }
            map.put(parent,node);
        }
        int parent = 0;
        //FInd the parent
        for(int i:map.keySet()){
            if(!children.contains(i)){
                parent = i;
                break;
            }
        }
        return map.get(parent);
    }
}
