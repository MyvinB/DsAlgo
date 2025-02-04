package Daily;

public class LC1800 {

    public int maxAscendingSum(int[] nums) {
        int max = 0;
        int preSum = 0;
        for(int i=0;i<nums.length;i++){
            if(i!=0 && nums[i]<=nums[i-1]){
                max = Math.max(max,preSum);
                preSum = 0;
            }
            preSum+=nums[i];
        }
        max = Math.max(max,preSum);
        return max;
    }
}
