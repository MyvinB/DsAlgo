package Topics.Arrays;

import java.util.Arrays;

public class LC1536 {

    public static void main(String[] args) {
        //[0,0,1],[1,1,0],[1,0,0]
        //[[0,1,1,0],[0,1,1,0],[0,1,1,0],[0,1,1,0]]
        //[1,0,0,0],[1,1,1,1],[1,0,0,0],[1,0,0,0]
        //[[1,0,0,0,0,0],[0,0,0,1,0,0],[0,0,0,1,0,0],[0,1,0,0,0,0],[0,0,1,0,0,0],[0,0,0,0,0,1]]
        int[][] e = new int[][]{{1,0,0,0,0,0},{0,0,0,1,0,0},{0,0,0,1,0,0},{0,1,0,0,0,0},{0,0,0,0,0,1}};
        int[][] f = new int[][]{{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}};
        int[][] t = new int[][]{{0,0,1},{1,1,0},{1,0,0}};
        int[][] p = new int[][]{{0,1,1,0},{0,1,1,0},{0,1,1,0},{0,1,1,0}};
        System.out.println(minSwaps(t));
    }

    public static int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] t = new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    t[i] = j;
                }
            }
        }
        int swaps = 0;
        // Fix positions from top to bottom
        for (int i = 0; i < n; i++) {
            int j = i;
            while(j<n && t[j]>i){
                j++;
            }
            if(j==n) return -1;
            while(j>i){
                int temp = t[j-1];
                t[j-1] = t[j];
                t[j] = temp;
                swaps++;
                j--;
            }
        }

        return swaps;
    }
}
