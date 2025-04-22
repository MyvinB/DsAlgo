package Topics.Sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] t = new int[]{9,14,15,12,6,8,13};
        System.out.println(Arrays.toString(insertionSort(t)));
    }


    public static int[] insertionSort(int[] nums) {
        int n = nums.length;
        for(int i=1;i<n;i++){
            int k=i;
            while(k>0 && nums[k]<nums[k-1]){
                int temp = nums[k];
                nums[k] = nums[k-1];
                nums[k-1] = temp;
                k--;
            }
        }
        return nums;
    }
}
