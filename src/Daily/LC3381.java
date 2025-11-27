package Daily;

import java.util.Arrays;

public class LC3381 {

    public static void main(String[] args) {

    }

    public long maxSubarraySum(int[] nums, int k) {
        long[] kSum = new long[k];
        Arrays.fill(kSum, Long.MAX_VALUE/2);
        int n = nums.length;
        kSum[k-1] = 0;
        long maxSum = Long.MIN_VALUE,preSum = 0;
        for(int i=0;i<n;i++){
            preSum+=nums[i];
            maxSum = Math.max(maxSum,preSum-kSum[i%k]);
            kSum[i%k] = Math.min(kSum[i%k],preSum);
        }
        return maxSum;

    }
}
