package Year26.Daily;

import javax.swing.*;

public class LC3010 {

    public static void main(String[] args) {
        int[] t = new int[]{2,2,1};
        System.out.println(minimumCost(t));
    }

    public static int minimumCost(int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int min3 = Integer.MAX_VALUE;
        int k = 0;
        int l = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<min1){
                min3 = min2;
                min2 = min1;
                min1 = nums[i];
            }else if(nums[i]<min2){
                min3 = min2;
                min2 = nums[i];
            }else if(nums[i]<min3){
                min3 = nums[i];
            }
        }
        if(nums[0]==min1 || nums[0]==min2 ){
            return min1+min2+min3;
        }
        return nums[0]+min1+min2;
    }
}
