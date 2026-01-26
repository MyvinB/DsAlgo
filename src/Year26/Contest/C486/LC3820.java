package Year26.Contest.C486;

import java.util.*;

public class LC3820 {

    public static void main(String[] args) {
        int[][] t = new int[][]{{0,1},{0,2},{0,3}};
        System.out.println(specialNodes(4,t,1,2,3));
    }

    public static int specialNodes(int n, int[][] edges, int x, int y, int z) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        int[] dx = bfs(n,adjList,x);
        int[] dy = bfs(n,adjList,y);
        int[] dz = bfs(n,adjList,z);
        int count =0;
        for(int i=0;i<n;i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(dx[i]);
            temp.add(dy[i]);
            temp.add(dz[i]);
            Collections.sort(temp);
            int a = temp.get(0);
            int b = temp.get(1);
            int c = temp.get(2);
            if((a*a+b*b)==c*c){
                count++;
            }
        }
        return count;
    }

    public static int[] bfs(int size,List<List<Integer>> adjList, int curNode){
        int[] d = new int[size];
        Arrays.fill(d,-1);
        Queue<Integer> queue = new LinkedList<>();
        d[curNode] = 0;
        queue.offer(curNode);
        while(!queue.isEmpty()){
            int u = queue.poll();
            for(int v: adjList.get(u)){
                if(d[v]==-1){
                    d[v] = d[u]+1;
                    queue.offer(v);
                }
            }
        }
        return d;
    }
}
