package Daily;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC1605 {


    public static void main(String[] args) {
        int[] rowSum = new int[]{14,9};
        int[] colSum = new int[]{6,9,8};
//        System.out.println(Arrays.deepToString(restoreMatrix(rowSum,colSum)));
    }


    //nonsense
    public static int[][] restoreMatrixNaive(int[] rowSum, int[] colSum) {
        PriorityQueue<int[]> rowPq = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        PriorityQueue<int[]> colPq = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        int m = rowSum.length;
        int n = colSum.length;
        for(int i=0;i<m;i++){
            rowPq.add(new int[]{i,rowSum[i]});
        }
        for(int j=0;j<n;j++){
            colPq.add(new int[]{j,colSum[j]});
        }

        int[][] mat = new int[m][n];
        while(!rowPq.isEmpty() ||!colPq.isEmpty()){

            if(!rowPq.isEmpty() && !colPq.isEmpty()){
                int[] row = rowPq.poll();
                int[] col = colPq.poll();
                mat[row[0]][col[0]] = Math.min(row[1],col[1]);
                if(col[1]>row[1]){
                    col[1] = col[1]-row[1];
                    colPq.add(col);
                }else if(row[1]>col[1]){
                    row[1] = row[1]-col[1];
                    rowPq.add(row);
                }

            }
            else if(!rowPq.isEmpty()){
                int[] row = rowPq.poll();
                mat[row[0]][0] = row[1];
            }
            else if(!colPq.isEmpty()){
                int[] col = colPq.poll();
                mat[0][col[0]] = col[1];
            }
        }
        return mat;
    }


    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;
        int[][] mat = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(rowSum[i]<=colSum[j]){
                    mat[i][j] = rowSum[i];
                }
                else if(rowSum[i]>colSum[j]){
                    mat[i][j] = colSum[j];
                }
                rowSum[i] -=mat[i][j];
                colSum[j] -=mat[i][j];
            }
        }
        return mat;
    }
}
