package Year26.Daily;

public class LC3637 {

    public static void main(String[] args) {
        int[] t = new int[]{1, 5, 2, 6, 4};
        System.out.println(isTrionic(t));
    }

    public static boolean isTrionic(int[] nums) {
        int n = nums.length;
        boolean firstIncrease = false;
        boolean firstDecrease = false;
        boolean lastIncrease = false;

        for(int i=1;i<n;i++){
            if(!firstIncrease && nums[i]>nums[i-1]){
                firstIncrease=true;
            }
            else if(!firstDecrease && firstIncrease && nums[i]<nums[i-1]){
                firstDecrease = true;
            }
            else if(nums[i]>nums[i-1] && firstDecrease && firstIncrease){
                lastIncrease = true;
            }else if(lastIncrease && nums[i]<nums[i-1] || !firstIncrease && nums[i]<nums[i-1] || nums[i]==nums[i-1]){
                return false;
            }

        }
        return firstIncrease&&firstDecrease&&lastIncrease;

    }
}
