package Recursion;

import java.util.ArrayList;
import java.util.List;

public class TUFPowerSet {

    public static void main(String[] args) {
        int[] t = new int[]{1,2,3};
        System.out.println(powerSet(t));
    }


    public static List<List<Integer>> powerSet(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
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
        recur(i+1,nums,temp,res);

    }
}
