package Daily;

import java.util.*;

public class LC1514 {

    public static void main(String[] args) {
        int[][] edges = new int[][]{{0,1},{1,2},{0,2}};
        double[] prob = new double[]{0.5,0.5,0.2};
        System.out.println(maxProbability(3,edges,prob,0,2));
    }

    public static double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b)->Double.compare(b[0],a[0]));
        //Now make adjList
        Map<Integer,List<double[]>> adjList = new HashMap<>();
        for(int i=0;i<edges.length;i++){
            int from = edges[i][0];
            int to = edges[i][1];
            double distance = succProb[i];
            adjList.computeIfAbsent(from,k->new ArrayList<>()).add(new double[]{distance,to});
            adjList.computeIfAbsent(to,k->new ArrayList<>()).add(new double[]{distance,from});
        }
        double[] dist = new double[n];
        Arrays.fill(dist,Integer.MIN_VALUE);
        pq.offer(new double[]{1,start_node});
        dist[start_node] = 1d;

        while(!pq.isEmpty()){
            double[] node = pq.poll();
            double d = node[0];
            int u = (int) node[1];
            if(u==end_node){
                return d;
            }
            for(double[] v:adjList.getOrDefault(u,new ArrayList<>())){
                double totalDistance = d *v[0];
                int k = (int) v[1];
                if(totalDistance >dist[k]){
                    dist[k] = totalDistance;
                    pq.offer(new double[]{totalDistance,k});
                }
            }
        }

        return dist[end_node]!=Integer.MIN_VALUE?dist[end_node]:0;

    }
}
