package Topics.Grid;

import java.util.Arrays;

public class LC3643 {

    public static void main(String[] args) {
        int[][] t = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] t1 = new int[][]{{3,4,2,3},{2,3,4,2}};
        reverseSubmatrix(t1,0,2,2);
        System.out.println(Arrays.deepToString(t1));
    }

    public static int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i=x;i<x+k/2;i++){
            for(int j=y;j<y+k;j++){
                int temp = grid[i][j];
                grid[i][j] = grid[x+k-1-(i-x)][j];
                grid[x+k-1-(i-x)][j] = temp;
            }
        }
        return grid;
    }
}
