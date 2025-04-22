package Topics.Sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] t = new int[]{13,46,24,52,20,9};
        System.out.println(Arrays.toString(bubbleSort(t)));
    }

    public static int[] bubbleSort(int[] nums) {
        int n= nums.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n-1-i;j++){
                if(nums[j]>nums[j+1]){
                    int temp= nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        return nums;
    }
}
