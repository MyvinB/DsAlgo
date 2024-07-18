package Daily;


import java.util.*;

public class LC1530 {

    public static void main(String[] args) {

    }


    public int countPairs(TreeNode root, int distance) {
        HashMap<TreeNode, List<TreeNode>> adjList = new HashMap<>();
        Set<TreeNode> leafNode = new HashSet<>();
        traverseTree(root,null,adjList,leafNode);
        int ans =0;
        for(TreeNode leaf:leafNode){
            Queue<TreeNode> queue = new LinkedList<>();
            Set<TreeNode> seen = new HashSet<>();
            queue.add(leaf);
            seen.add(leaf);
            for(int i=0;i<=distance;i++){
                int size = queue.size();
                for(int k=0;k<size;k++){
                    TreeNode cur = queue.poll();
                    if(leafNode.contains(cur) && cur!=leaf){
                        ans++;
                    }
                    if(adjList.containsKey(cur)){
                        for(TreeNode node:adjList.get(cur)){
                            if(!seen.contains(node)){
                                seen.add(node);
                                queue.add(node);
                            }
                        }
                    }
                }

            }
        }
        return ans/2;

    }

    private void traverseTree(TreeNode cur,TreeNode prev,Map<TreeNode,List<TreeNode>> adjList,Set<TreeNode> leafNodes){
        if(cur==null) return;
        if(cur.left == null && cur.right==null)leafNodes.add(cur);
        if(prev!=null){
            adjList.computeIfAbsent(cur,k->new ArrayList<TreeNode>() );
            adjList.computeIfAbsent(prev,k->new ArrayList<TreeNode>());
            adjList.get(cur).add(prev);
            adjList.get(prev).add(cur);
        }
        traverseTree(cur.left,cur,adjList,leafNodes);
        traverseTree(cur.right,cur,adjList,leafNodes);
    }
}

