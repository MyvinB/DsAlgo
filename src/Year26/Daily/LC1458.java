package Year26.Daily;

public class LC1458 {

    public static void main(String[] args) {

    }

    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        Integer[][] dp = new Integer[m][n];
        return solve(0, 0, nums1, nums2, dp);
    }


    public int solve(int i, int j, int[] nums1, int[] nums2, Integer[][] dp) {
        if (i >= nums1.length || j >= nums2.length) return Integer.MIN_VALUE;
        if (dp[i][j] != null) return dp[i][j];
        int product = nums1[i] * nums2[j];
        int include = product + Math.max(0, solve(i + 1, j + 1, nums1, nums2, dp));
        int exclude1 = solve(i + 1, j, nums1, nums2, dp);
        int exclude2 = solve(i, j + 1, nums1, nums2, dp);
        return dp[i][j] = Math.max(include, Math.max(exclude1, exclude2));
    }
}
