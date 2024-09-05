package Daily;

import java.util.Arrays;

public class LC2699 {


    public static void main(String[] args) {
        int[][] edges = new int[][]{{4,1,-1}};
    }

    static final int INF = (int) 1e9;

    public int[][] modifiedGraphEdges(int n, int[][] edges, int src, int dst, int t) {
        for (int[] e : edges) {
            if (e[2] == -1) {
                e[2] = INF;
            }
        }

        int[][] dist = new int[n][n];
        for (int[] row : dist) Arrays.fill(row, INF);
        for (int i = 0; i < n; i++) dist[i][i] = 0;
        for (int[] e : edges) {
            dist[e[0]][e[1]] = e[2];
            dist[e[1]][e[0]] = e[2];
        }

        // floyd-warshall
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // found
        if (dist[src][dst] == t) {
            return edges;
        }
        // not possible
        if (dist[src][dst] < t) {
            return new int[][] {};
        }

        return edges;
    }
}
