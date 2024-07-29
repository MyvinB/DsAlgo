package Revise.ShortestPath;

public class FloydWarshall {


    //Problem Link:https://www.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=implementing-floyd-warshall
    public static void main(String[] args) {

    }

    public void shortest_distance(int[][] matrix)
    {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]==-1){
                    matrix[i][j] = (int) 1e9;
                }
                if(i==j){
                    matrix[i][j] = 0;
                }
            }
        }

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    int distance = matrix[i][k] + matrix[k][j];
                    matrix[i][j] = Math.min(distance,matrix[i][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]==(int) 1e9){
                    matrix[i][j] = -1;
                }
            }
        }
    }
}
