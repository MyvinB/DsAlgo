package Year26.Daily;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC712 {


    public static void main(String[] args) {
        String s1 = "delete";
        String s2 = "leet";
        System.out.println(tabulation(s1, s2));
        System.out.println(minimumDeleteSum(s1,s2));
    }


    public static int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m][n];
        int[][] dp1 = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
            Arrays.fill(dp1[i],-1);
        }
        int sum = recur(s1,s2,m-1,n-1,dp);
        int s1Sum = 0;
        int s2Sum = 0;
        for(int i=0;i<s1.length();i++){
            s1Sum+=s1.charAt(i);
        }
        for(int j=0;j<s2.length();j++){
            s2Sum+=s2.charAt(j);
        }
        return s1Sum+s2Sum-sum;
    }


    public static int recur(String s1, String s2, int i, int j,int[][] dp){
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j] = s1.charAt(i)*2 + recur(s1,s2,i-1,j-1,dp);
        }
        else return dp[i][j] = Math.max(recur(s1,s2,i-1,j,dp),recur(s1,s2,i,j-1,dp));
    }


    public static int recurDiff(String s1,String s2, int i,int j, int[][] dp){
        if(i>=s1.length() || j>=s2.length()) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j] = 2*s1.charAt(i) +recurDiff(s1,s2,i+1,j+1,dp);
        }
        else return dp[i][j] = Math.max(recurDiff(s1,s2,i+1,j,dp),recurDiff(s1,s2,i,j+1,dp));
    }

    public static int tabulation(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(s1.charAt(i)==s2.charAt(j)){
                    dp[i][j] = s1.charAt(i)*2 + dp[i+1][j+1];
                } else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        int s1Sum = 0;
        int s2Sum = 0;
        for(int i=0;i<s1.length();i++){
            s1Sum+=s1.charAt(i);
        }
        for(int j=0;j<s2.length();j++){
            s2Sum+=s2.charAt(j);
        }
        return s1Sum+s2Sum-dp[0][0];
    }
}
