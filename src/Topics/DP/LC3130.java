package Topics.DP;

import java.util.Arrays;

public class LC3130 {

    public static void main(String[] args) {
        System.out.println(numberOfStableArrays(1,1,2));
    }

    static int MOD = 1_000_000_007;
    static int[][][] dp;
    static int limit;

    public static int numberOfStableArrays(int zero, int one, int limit) {
        limit = limit;
        dp = new int[zero + 1][one + 1][3];

        for(int i=0;i<=zero;i++)
            for(int j=0;j<=one;j++)
                Arrays.fill(dp[i][j], -1);

        return recur(zero, one, 2);
    }

    private static int recur(int zero, int one, int last){

        if(zero == 0 && one == 0)
            return 1;

        if(dp[zero][one][last] != -1)
            return dp[zero][one][last];

        long count = 0;

        // place zeros
        if(last != 0){
            for(int k=1; k<=limit && zero-k>=0; k++){
                count += recur(zero-k, one, 0);
                count %= MOD;
            }
        }

        // place ones
        if(last != 1){
            for(int k=1; k<=limit && one-k>=0; k++){
                count += recur(zero, one-k, 1);
                count %= MOD;
            }
        }

        return dp[zero][one][last] = (int)count;
    }
}
