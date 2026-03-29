package Topics.Grid;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class LC3567 {


    public static void main(String[] args) {

    }
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m-k+1][n-k+1];
        for(int i=0;i<m-k+1;i++){
            for(int j=0;j<n-k+1;j++){
                TreeSet<Integer> set = new TreeSet<>();
                for(int r=i;r<i+k;r++){
                    for(int c=j;c<j+k;c++){
                        set.add(grid[r][c]);
                    }
                }
                int minDiff = Integer.MAX_VALUE;
                int prev = set.pollFirst();
                while(!set.isEmpty()){
                    int cur = set.pollFirst();
                    minDiff = Math.min(minDiff,cur-prev);
                    prev = cur;
                }
                ans[i][j] = minDiff;
            }
        }
        return ans;
    }
}
