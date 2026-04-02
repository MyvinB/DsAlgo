package Topics.DP;

public class LC3418 {

    public static void main(String[] args) {
        int[][] t = new int[][]{{0,1,-1},{1,-2,3},{2,-3,4}};
        System.out.println(maximumAmount(t));
    }

    public static int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        int[][][] dp = new int[m][n][3];

        // initialize with a marker (uncomputed)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= 2; k++) {
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }
        return recurMemo(coins,0,0,2,dp);

    }


    public static int recurMemo(int[][] coins,int x,int y,int k, int[][][] dp){
        int m = coins.length;
        int n = coins[0].length;

        // boundary
        if (x >= m || y >= n) return Integer.MIN_VALUE;

        // base case
        if (x == m - 1 && y == n - 1) {
            if (coins[x][y] < 0 && k > 0) return 0;
            return coins[x][y];
        }

        // memo check
        if (dp[x][y][k] != Integer.MIN_VALUE) {
            return dp[x][y][k];
        }

        int best = Integer.MIN_VALUE;

        // moves
        int[][] dirs = {{0, 1}, {1, 0}};

        for (int[] d : dirs) {
            int nx = x + d[0];
            int ny = y + d[1];

            int next = recurMemo(coins, nx, ny, k,dp);

            // OPTION 1: take value
            if (next != Integer.MIN_VALUE) {
                best = Math.max(best, coins[x][y] + next);
            }

            // OPTION 2: skip negative
            if (coins[x][y] < 0 && k > 0) {
                int skipNext = recurMemo(coins, nx, ny, k - 1,dp);
                if (skipNext != Integer.MIN_VALUE) {
                    best = Math.max(best, skipNext);
                }
            }
        }

        return dp[x][y][k] = best;
    }
}
