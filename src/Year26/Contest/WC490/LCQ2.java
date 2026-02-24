package Year26.Contest.WC490;

import java.awt.desktop.PreferencesEvent;
import java.util.Arrays;
import java.util.HashSet;

public class LCQ2 {

    public static void main(String[] args) {
        System.out.println(isDigitorialPermutation(133));
    }

    public static boolean isDigitorialPermutation(int n) {
        long total = 0;
        long oldN = n;
        long[] dp = new long[15];
        Arrays.fill(dp,-1);
        char[] arr = String.valueOf(oldN).toCharArray();
        Arrays.sort(arr);
        while(n!=0){
           total+= getFactorial(n%10,dp);
           n= n/10;
        }
        if(total==oldN){
            return true;
        }
        char[] toCheck = String.valueOf(total).toCharArray();
        Arrays.sort(toCheck);
        int arSize = arr.length;
        int toCheckSize = toCheck.length;
        if(arSize!=toCheckSize) return false;
        for(int i =0;i<arSize;i++){
            if(arr[i]!=toCheck[i]) return false;
        }
        return true;
    }

    private static long getFactorial(int n , long[] dp){
        if(n==0) return 1;
        if(dp[n]!=-1) return dp[n];
        return dp[n] = n * getFactorial(n-1,dp);
    }
}
