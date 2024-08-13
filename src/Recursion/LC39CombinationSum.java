package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC39CombinationSum {

    public static void main(String[] args) {
        int[] t = new int[]{2,3,6,7 };
        System.out.println(combinationSum(t,7));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        recur(0,target,candidates,res, new ArrayList<>());
        return res;
    }

    public static void recur(int i,int sum, int[] candidates,List<List<Integer>> res,List<Integer> temp){
        //Get resulting tree
        if(sum==0){
            res.add(new ArrayList<>(temp));
            return;
        }
        //Base Conditions
        if(sum<0 || i==candidates.length){
            return;
        }
        //Choosing the current index
        temp.add(candidates[i]);
        recur(i,sum-candidates[i],candidates,res,temp);
        temp.remove(temp.size()-1);

        //Not choosing the current index
        recur(i+1,sum,candidates,res,temp);
    }



}
