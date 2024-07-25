package Revise.SortingAlgo;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] t1 = new int[]{5,1,1,2,0,0};
        mergeSort(t1,0, t1.length-1);
        System.out.println(Arrays.toString(t1));

    }



    public static void mergeSort(int[] arr,int low, int high){
        //Base case:
        if(low>=high) return;
        int mid = (low+high)/2;
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);
        merge(arr,low,mid,high);
    }


    public static void merge(int[] arr, int low,int mid,int high){
        int left = low;
        int right = mid+1;
        int[] temp = new int[high-low+1];
        int idx = 0;
        while(left<=mid && right<=high){
            if(arr[left]<=arr[right]){
                temp[idx++] = arr[left++];
            }
            else{
                temp[idx++] = arr[right++];
            }
        }
        while(left<=mid){
            temp[idx++] = arr[left++];
        }
        while(right<=high){
            temp[idx++] = arr[right++];
        }
        for(int i=low;i<=high;i++){
            arr[i] = temp[i-low];
        }
    }
}
