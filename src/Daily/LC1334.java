package Daily;

import java.util.Arrays;

public class LC1334 {


    public static void main(String[] args) {

    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        //Using flyod Marshal algo first
        int[][] matrix = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j] = (int)1e9;
            }
        }
        //Shortest distance to its node is zero
        for(int i=0;i<n;i++) matrix[i][i] = 0;

        for(int[] e: edges){
            int i = e[0];
            int j = e[1];
            int d = e[2];
            matrix[i][j] = d;
            matrix[j][i] = d;
        }

        //All minimum paths calculated
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    int d = matrix[i][k] + matrix[k][j];
                    matrix[i][j] = Math.min(d,matrix[i][j]);
                }
            }
        }

        int minCities = n+1;
        int city = -1;
        for(int i=0;i<n;i++){
            int cityVisitCount = 0;
            for(int j=0;j<n;j++){
                int d = matrix[i][j];
                if(d<=distanceThreshold){
                    cityVisitCount++;
                }
            }
            if(cityVisitCount<=minCities){
                city = i;
                minCities = cityVisitCount;
            }
            cityVisitCount = 0;
        }

        return city;
    }
}
