package Daily;

import java.util.*;

public class LC2392 {

    public static void main(String[] args) {
        int[][] r = new int[][]{{1,2},{2,3},{3,1},{2,3}};
        int[][] c = new int[][]{{2,1}};
        buildMatrix(3,r,c);
    }

    public static int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[] rowOrder = topoSort(rowConditions,k);
        int[] colOrder = topoSort(colConditions,k);
        System.out.println(Arrays.toString(rowOrder));
        System.out.println(Arrays.toString(colOrder));
        if(colOrder.length==0 || rowOrder.length==0) return new int[0][0];
        int[][] matrix = new int[k][k];
        for(int i=0;i<k;i++){
            for(int j=0;j<k;j++){
                System.out.println(i+" "+j);
                if(rowOrder[i]==colOrder[j]){
                    matrix[i][j]=rowOrder[i];
                }
            }
        }
        return matrix;
    }


    public static int[] topoSort(int[][] conditions, int n){
        List<Integer>[] adjList = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            adjList[i] = new ArrayList<>();
        }
        int[] inDegree = new int[n+1],order = new int[n];
        int idx = 0;
        for(int[] c:conditions){
            adjList[c[0]].add(c[1]);
            inDegree[c[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=n;i++){
            if(inDegree[i]==0)queue.offer(i);
        }
        while(!queue.isEmpty()){
            int elem = queue.poll();
            order[idx++] = elem;
            n--;
            for(int v:adjList[elem]){
                if(--inDegree[v]==0)queue.offer(v);

            }
        }
        if(n!=0) return new int[0];
        return order;
    }
}
