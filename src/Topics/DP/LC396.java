package Topics.DP;

public class LC396 {

    public static void main(String[] args) {

    }

    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        int F = 0;
        for(int i=0;i<n;i++){
            totalSum+=nums[i];
            F +=(i*nums[i]);
        }
        int max = F;
        for(int k=1;k<n;k++){
            F = F + totalSum - n*nums[n-k];
            max = Math.max(F,max);
        }
        return max;

    }
}
