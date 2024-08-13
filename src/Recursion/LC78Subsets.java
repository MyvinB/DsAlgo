package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC78Subsets {

    public static void main(String[] args) {
        int[] t = new int[]{1,2,2};
        System.out.println(subsetsWithDup(t));
    }


    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        recur(0,nums,new ArrayList<>(),res);
        return res;
    }


    public static void recur(int i,int[] nums, List<Integer> temp, List<List<Integer>> res){
        //Base conditions and adding to array
        if(i==nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        //Choosing the value
        temp.add(nums[i]);
        recur(i+1,nums,temp,res);
        temp.remove(temp.size()-1);

        //Ignoring the current value and moving forward
        for(int j=i+1;j<nums.length;j++){
            if(nums[i]!=nums[j]){
                recur(j,nums,temp,res);
                return;
            }
        }
        //This is done in case of [2,2] here the entire call breaks if this line is not there as
        recur(nums.length,nums,temp,res);
    }
}
