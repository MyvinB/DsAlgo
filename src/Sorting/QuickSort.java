package Sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] t = new int[]{3,1,2,4,1,5,2,6,4};
        quickSort(0,t.length-1,t);
        System.out.println(Arrays.toString(t));

    }

    private static void swap(int[] nums,int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int partion(int low,int high,int[] nums) {
        int n = nums.length;
        int pivot = nums[low];
        int i = low;
        int j = high;
        while(i<j){
            while(nums[i]<=pivot && i<high) i++;
            while(nums[j]>pivot && j>=low) j--;
            if(i<j)swap(nums,i,j);
        }
        //j>i we reached pivot swap position
        swap(nums,low,j);
        return j;
    }

    public static void quickSort(int low,int high,int[] nums){
        if(low>=high) return;
        int pIndex = partion(low,high,nums);
        quickSort(low,pIndex-1,nums);
        quickSort(pIndex+1,high,nums);
    }
}
