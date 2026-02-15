package Year26.Contest.BIWC176;

import java.util.Arrays;

public class Q3 {

    public static void main(String[] args) {
        int[] t = {10,1,3,9};
        int[] c = {1,1,1,2};
        System.out.println(rob(t,c));
    }

    public static long rob(int[] nums, int[] colors) {
        int n = nums.length;
        int[][] dp = new int[n+1][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return recurMemo(nums,colors,0,0,dp);
    }

    public static int recurMemo(int[] nums,int[] colors, int idx,int didRob, int[][] dp){
        //Base Case
        if(idx==nums.length) return 0;
        if(dp[idx][didRob]!= -1) return dp[idx][didRob];
        int notRob = recurMemo(nums,colors,idx+1,0,dp);
        if(idx!=0 &&  colors[idx]==colors[idx-1] && didRob==1) return dp[idx][didRob] = notRob;
        //to rob
        int rob = nums[idx] + recurMemo(nums,colors,idx+1,1,dp);
        return dp[idx][didRob]  = Math.max(rob,notRob);
    }
}
