package Year26.Daily;

import java.util.Arrays;

public class LC3379 {

    public static void main(String[] args) {
        int[] t = new int[]{-10,-10,-4};
        System.out.println(Arrays.toString(constructTransformedArray(t)));
    }

    public static int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int index = 0;
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                index = (i+nums[i])%n;
                res[i] = nums[index];
            }
            else if(nums[i]<0){
                index = (i+nums[i]);
                if(index<0){
                    index = Math.abs(index)%n;
                    if(index!=0) index = n-index;
                    res[i] = nums[index];
                } else{
                    res[i] = nums[index];
                }

            }
        }
        return res;
    }

    public int[] constructTransformedArrayOtp(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int index = 0;
        for(int i=0;i<n;i++){
            index = ((i + nums[i]) % n + n) % n;
            res[i] = nums[index];
        }
        return res;
    }
}
