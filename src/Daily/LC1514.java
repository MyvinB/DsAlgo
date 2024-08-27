package Daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class LC1514 {

    public static void main(String[] args) {
        int[][] edges = new int[][]{{0,1},{1,2},{0,2}};
        double[] prob = new double[]{0.5,0.5,0.2};
        System.out.println(maxProbability(3,edges,prob,0,2));
    }

    public static double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b)->{
            if(a[0]==b[0]) return Double.compare(a[1],b[1]);
            else return Double.compare(a[0],b[0]);
        });
        //Now make adjList
        List<List<double[]>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int from = edges[i][0];
            int to = edges[i][1];
            double distance = succProb[i];
            adjList.get(from).add(new double[]{distance,to});
        }
        double[] dist = new double[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        pq.offer(new double[]{1,0});

        while(!pq.isEmpty()){
            double[] node = pq.poll();
            double d = node[0];
            int u = (int) node[1];
            for(double[] v:adjList.get(u)){
                double totalDistance = d *v[0];
                int k = (int) v[1];
                if(totalDistance<dist[k]){
                    dist[k] = totalDistance;
                    pq.offer(new double[]{totalDistance,k});
                }
            }
        }

        return dist[n-1];

    }
}
