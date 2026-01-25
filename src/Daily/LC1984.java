package Daily;

import java.util.Arrays;

public class LC1984 {

    public static void main(String[] args) {
        int[] t = new int[]{9,4,1,7};
        int[] t1 = new int[]{87063,61094,44530,21297,95857,93551,9918};
        int[] t2 = new int[]{20,200,300,1000};
        System.out.println(minimumDifference(t1,6));
    }

    public static int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0;i+k-1<n;i++){
            int low = nums[i];
            int high = nums[i+k-1];
            min = Math.min(min,high-low);
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}
