package Year26.Daily;

import java.util.Stack;

public class LC1653 {

    public static void main(String[] args) {
        minimumDeletionsOptimisedStackDp("aababbab");
    }

    public static int minimumDeletions(String s) {
        int bCount = 0;
        int aCount = 0;
        int n = s.length();
        int[] bArr = new int[n];
        int[] aArr = new int[n];
        for(int i=0;i<n;i++){
            bArr[i] = bCount;
            if(s.charAt(i)=='b') bCount++;
        }

        for(int j=n-1;j>=0;j--){
            aArr[j] = aCount;
            if(s.charAt(j)=='a') aCount++;
        }
        int min = n;
        for(int i=0;i<n;i++){
            min = Math.min(min,bArr[i]+aArr[i]);
        }
        return min;
    }

    public static int minimumDeletionsOptimisedStack(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        int delCount = 0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='a' && !stack.isEmpty() && stack.peek()=='b'){
                stack.pop();
                delCount++;
            }else{
                stack.push(s.charAt(i));
            }
        }
        return delCount;
    }

    public static int minimumDeletionsOptimisedStackDp(String s){
        int n = s.length();
        int[] dp = new int[n+1];
        int bCount = 0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='b'){
                dp[i+1] = dp[i];
                bCount++;
            }else{
                dp[i+1] = Math.min(dp[i]+1,bCount);
            }
        }
        return dp[n];
    }
}
