package Year26.Daily;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LC3650 {

    public static void main(String[] args) {

    }

    class Pair{
        long c;
        int x;
        Pair(int x,long c){
            this.c = c;
            this.x = x;
        }
    }

    public int minCost(int n, int[][] edges) {
        List<List<int[]>> graph = new ArrayList<>();
        List<List<int[]>> revGraph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
            revGraph.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int c = edge[2];
            graph.get(u).add(new int[]{v,c});
            revGraph.get(v).add(new int[]{u,2*c});
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Long.compare(a.c,b.c));
        long[] d = new long[n];
        for(int i =0;i<d.length;i++){
            d[i] = Long.MAX_VALUE;
        }
        d[0] = 0;
        pq.offer(new Pair(0,0L));
        while(!pq.isEmpty()){
            Pair top = pq.poll();
            int u = top.x;
            long cost = top.c;
            if(cost>d[u]) continue;
            if(u==n-1) return (int)d[u];
            //Graph
            for(int[] edge:graph.get(u)){
                int v = edge[0];
                int w = edge[1];
                if(d[u]+w<d[v]){
                    d[v] = d[u]+w;
                    pq.offer(new Pair(v,d[v]));
                }
            }
            //To GO Rev is better
            for(int[] edge:revGraph.get(u)){
                int v = edge[0];
                int w = edge[1];
                if(d[u]+w<d[v]){
                    d[v] = d[u]+w;
                    pq.offer(new Pair(v,d[v]));
                }
            }
        }
        return -1;
    }
}
