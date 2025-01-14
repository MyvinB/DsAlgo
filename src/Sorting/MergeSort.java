package Sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] t = new int[]{3,1,2,4,1,5,2,6,4};
        System.out.println(Arrays.toString(mergeSort(t)));
    }

    public static int[] mergeSort(int[] nums) {
        mergeSortHelper(0,nums.length-1,nums);
        return nums;
    }

    private static void merge(int low, int mid, int high, int[] nums){
        int left = low;
        int right = mid+1;
        int[] temp = new int[high-low+1];
        int i = 0;
        while(left<=mid && right<=high){
            if(nums[left]<=nums[right]){
                temp[i++] = nums[left++];
            }else{
                temp[i++] = nums[right++];
            }
        }
        while(left<=mid){
            temp[i++]=nums[left++];
        }
        while(right<=high){
            temp[i++] = nums[right++];
        }
        for(int t=low;t<=high;t++){
            nums[t] = temp[t-low];
        }
    }

    public static void mergeSortHelper(int low, int high, int[] nums){
        if(low>=high) return;
        int mid = (low+high)/2;
        mergeSortHelper(low,mid,nums);
        mergeSortHelper(mid+1,high,nums);
        merge(low,mid,high,nums);
    }


}
