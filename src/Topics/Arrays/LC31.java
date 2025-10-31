package Topics.Arrays;

import java.util.Arrays;

/**
 * Created by myvinbarboza on 10/09/25 at 11:04 PM
 * Today is a Wednesday
 */
public class LC31 {

    public static void main(String[] args) {
        int[] t = new int[]{3,2,1};
        nextPermutation(t);
        System.out.println(Arrays.toString(t));
    }

        /*
    1) Find the dip from the right side cause you need the next permutation.
    2) Replace the element with the next greatest element
    3) Sort the element with the reverse logic using two pointer cause it is already sorted
    if you have 3,2,1 it will automatically bring the prev permutationie 1,2,3 which you would get by reverse
     */
    public static void nextPermutation(int[] nums) {
        int n= nums.length;
        int idx = -1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                idx= i;
                break;
            }
        }

        if(idx!=-1){
            //Swap now
            for(int i=n-1;i>=idx;i--){
                if(nums[i]>nums[idx]){
                    swap(nums,i,idx);
                    break;
                }
            }
        }


        //reverse the last
        int i=idx+1,j=n-1;
        while(i<j){
            swap(nums,i++,j--);
        }
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
