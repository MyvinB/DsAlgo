package Daily;

import java.util.ArrayList;
import java.util.List;

public class LC947 {

    public static void main(String[] args) {

    }

    public int removeStones(int[][] stones) {
        int n = stones.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList());
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(stones[i][0]==stones[j][0] || stones[i][1] == stones[j][1]){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        int numOfConnected = 0;
        boolean vistied[] = new boolean[n];
        for(int i=0;i<n;i++){
            if(!vistied[i]){
                numOfConnected++;
                dfs(adjList,i,vistied);
            }
        }
        return n-numOfConnected;
    }


    public void dfs(List<List<Integer>> adjList,int stone,boolean[] visted){
        visted[stone] = true;
        for(int v:adjList.get(stone)){
            if(!visted[v]){
                dfs(adjList,v,visted);
            }
        }
    }

}
