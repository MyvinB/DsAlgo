package Array;

import java.util.Arrays;

public class LC1509 {

    public static void main(String[] args) {
        int[] t = new int[]{1,5,0,10,14};
        System.out.println(minDifference(t));
    }
    /*
    Think of logical possibilities of elements you can remove giving minimum difference
    We need to sort the array
    Now the left most element becomes large and the right most smaller we have 4 possibilities
    replace
    a)last 3 elements
    b)first 3 elements
    c)remove first 1 and last 2 elements
    d)remove first 2 and last 1 elements

    OA Google

    If we consider the case of 4 elements we can replace all 3 elements with untouched one resulting in zero.
     */

    public static int minDifference(int[] nums) {
        int n = nums.length;
        if(n<=4) return 0;
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        res=Math.min(res,nums[n-4]-nums[0]);
        res=Math.min(res,nums[n-1]- nums[3]);
        res=Math.min(res,nums[n-3]- nums[1]);
        res=Math.min(res,nums[n-2]- nums[2]);
        return res;
    }
}
