package Topics.DP;

import java.util.Arrays;

public class LC3129 {


    public static void main(String[] args) {
        System.out.println(numberOfStableArrays(1,2,1));
    }
    static int mod = 1_000_000_007;
    public static int numberOfStableArrays(int zero, int one, int limit) {
        int[][][][] dp = new int[zero+1][one+1][3][limit+1];
        for (int i = 0; i <= zero; i++) {
            for (int j = 0; j <= one; j++) {
                for (int k = 0; k < 3; k++) {
                    Arrays.fill(dp[i][j][k], -1);
                }
            }
        }
        return recurMemo(zero,one,2,0,limit,dp);
    }


    public static int recurMemo(int zero,int one,int last,int streak,int limit,int[][][][] dp){
        //base case
        if(zero==0 && one==0 ){
            return 1;
        }
        if(last !=2 && dp[zero][one][last][streak]!=-1){
            return dp[zero][one][last][streak];
        }
        int count = 0;
        //Handle only zero
        if(zero>0){
            if(last==0 && streak<limit){
                count= recurMemo(zero-1,one,0,streak+1,limit,dp);
                count%=mod;
            }
            else if(last!=0){
                count+= recurMemo(zero-1,one,0,1,limit,dp);
                count%=mod;
            }

        }
        if(one>0){
            if(last==1 && streak<limit){
                count+= recurMemo(zero,one-1,1,streak+1,limit,dp);
                count%=mod;
            }
            else if(last!=1){
                count+= recurMemo(zero,one-1,1,1,limit,dp);
                count%=mod;
            }
        }
        return dp[zero][one][last][streak]=count;
    }
}
