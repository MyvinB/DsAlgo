package Topics.Grid;

import java.util.HashSet;
import java.util.Set;

public class LC3546 {

    public static void main(String[] args) {
        int[][] t = new int[][]{{1,1,1}};
        System.out.println(canPartitionGrid(t));
    }

    public static boolean canPartitionGrid(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int sum = 0;
            int totalSum = 0;
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    totalSum+=grid[i][j];
                }
            }
            if ((totalSum & 1) == 1) {
                return false;
            }
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    sum+=grid[i][j];
                }
                if(sum*2==totalSum) return true;
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    sum+=grid[j][i];
                }
                if(sum*2==totalSum) return true;
            }

            return false;
    }
}
