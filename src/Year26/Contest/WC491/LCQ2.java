package Year26.Contest.WC491;

import java.util.Arrays;

public class LCQ2 {

    public static void main(String[] args) {
        System.out.println(minCost(4));
    }

    public static int minCost(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return getMinCost(n,dp);
    }


    public static int getMinCost(int n, int[] dp){
        if(n<=1) return 0;
        if(dp[n]!=-1){
            return dp[n];
        }
        int minCost = Integer.MAX_VALUE;
        for(int a=1;a<n;a++){
            int b = n - a;
            int cost = a * b + getMinCost(a, dp) + getMinCost(b, dp);
            minCost = Math.min(minCost, cost);
        }
        return dp[n]=minCost;
    }
}
