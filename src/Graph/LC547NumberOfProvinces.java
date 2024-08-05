package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC547NumberOfProvinces {

    public static void main(String[] args) {

    }


    public int findCircleNum(int[][] isConnected) {
        //Creating the adjList
        int m = isConnected.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<m;i++) adjList.add(new ArrayList<>());
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adjList.get(i).add(j);
                }
            }
        }
        int[] visited = new int[m];
        int count = 0;
        for(int i=0;i<m;i++){
            if(visited[i]==0){
                count++;
                bfs(i,visited,adjList);
            }
        }
        return count;
    }

    public void bfs(int node,int[] visited,List<List<Integer>> adjList){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = 1;
        while(!queue.isEmpty()){
            int idx = queue.poll();
            for(int t:adjList.get(idx)){
                if(visited[t] !=1){
                    visited[t]=1;
                    queue.offer(t);
                }
            }
        }
    }
}
