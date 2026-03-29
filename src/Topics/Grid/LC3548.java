package Topics.Grid;

import java.util.HashSet;

public class LC3548 {

    public static void main(String[] args) {

    }

    public boolean canPartionGrid(int[][] grid, long totalSum){
        long topSum = 0;
        int m = grid.length;
        int n = grid[0].length;
        HashSet<Long> set = new HashSet<>();
        for (int i = 0; i <m ; i++){
            for (int j = 0; j <n; j++){
                topSum += grid[i][j];
                set.add((long)grid[i][j]);
            }
            long bottomSum = totalSum-topSum;
            long diff = topSum-bottomSum;
            if(diff==0) return true;
            if(diff==grid[0][0]) return true;
            if(diff==grid[0][n-1]) return true;
            if(diff==grid[i][0]) return true;
            if(i>0 && n>1 && set.contains(diff)){
                return true;
            }
        }
        return false;
    }

    public void reverseMatrix(int[][] grid){
        int top = 0, bottom = grid.length - 1;
        while (top < bottom) {
            int[] temp = grid[top];
            grid[top] = grid[bottom];
            grid[bottom] = temp;

            top++;
            bottom--;
        }
    }


    public boolean canPartitionGrid(int[][] grid) {
        long totalSum = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] transposeGrid = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                totalSum+=grid[i][j];
            }
        }
        if(canPartionGrid(grid,totalSum)) return true;
        reverseMatrix(grid);
        if(canPartionGrid(grid,totalSum)) return true;
        reverseMatrix(grid);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                transposeGrid[j][i] = grid[i][j];
            }
        }
        if(canPartionGrid(transposeGrid,totalSum)) return true;
        reverseMatrix(transposeGrid);
        if(canPartionGrid(transposeGrid,totalSum)) return true;
        return false;
    }
}
