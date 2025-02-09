package Contest.Feb09;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LCQ1 {

    public static void main(String[] args) {
        //{{1,2,3},{5,8,7},{4,9,6}};
        int[][] matrix = new int[][]{{1,7,3},{9,8,2},{4,5,6}};
        System.out.println(Arrays.deepToString(sortMatrix(matrix)));
    }


    public static int[][] sortMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i=0,j=0;
        int isRowDone = 0;

        while(i<m & j<n){
            //Diagonals are now handled like this.
            while(i<m & j<n){
                pq.offer(grid[i][j]);
                i++;
                j++;
            }
            i--;j--;
            while(i>=0 & j>=0){
                grid[i][j]  = pq.poll();
                i--;
                j--;
            }
            i++;j++;
            if(i!=m-1 && isRowDone==0){
                i++;
            }else{
                j++;
                i=0;
                isRowDone = 1;
                pq= new PriorityQueue<>((a,b)->Integer.compare(b,a));
            }

        }

        return grid;
    }
}
