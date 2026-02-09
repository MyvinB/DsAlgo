package Topics.DP;

import java.util.Arrays;

public class LC1143LongestCommonSubsequence {


    public static void main(String[] args) {

    }


    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m][n];
        for(int[]d :dp) Arrays.fill(d,-1);
        return recur(text1,text2,m-1,n-1,dp);
    }



    public int recur(String text1, String text2, int i, int j, int[][] dp){
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(text1.charAt(i)==text2.charAt(j)){
            return 1+recur(text1,text2,i-1,j-1,dp);
        }
        return dp[i][j] = Math.max(recur(text1,text2,i-1,j,dp),recur(text1,text2,i,j-1,dp));
    }


    public int tabulation(String text1,String text2){
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1+1][n2+1];

        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = 1 +dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n1][n2];
    }
}
