package Year26.Daily;

import java.util.Arrays;

public class LC1877 {

    public static void main(String[] args) {

    }

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int i= 0,j=nums.length-1;
        int max = 0;
        while(i<j){
            int sum = nums[i] + nums[j];
            max = Math.max(sum,max);
            i++;
            j--;
        }
        return max;
    }

}
