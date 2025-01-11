package Sorting;

import java.util.Arrays;

public class SelectionSort {

    public static int[] selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[idx]) {
                    idx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] t = new int[]{7,4,1,5,3};
        System.out.println(Arrays.toString(selectionSort(t)));
    }
}



