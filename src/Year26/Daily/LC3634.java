package Year26.Daily;

import java.util.Arrays;

public class LC3634 {

    public static void main(String[] args) {

    }

    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int maxLen = 0;
        int n = nums.length;
        int i = 0;
        for(int j=0;j<n;j++){
            while((long)nums[j]>k*(long)nums[i]){
                i++;
            }
            maxLen = Math.max(maxLen,j-i+1);
        }
        return n-maxLen;
    }
}
