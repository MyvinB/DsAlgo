package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC40CombinationSumII {

    public static void main(String[] args) {
        int[] t = new int[]{10,1,2,7,6,1,5};
        System.out.println(combinationSum2(t,8));
    }


    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        recur(0,target,candidates,new ArrayList<>(),res);
        return res;
    }

    public static void recur(int i,int sum,int[] candidates,List<Integer> temp, List<List<Integer>> res){
        //Base conditions
        if(sum==0){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(sum<0 || i==candidates.length){
            return;
        }
        //Taking the current element
        temp.add(candidates[i]);
        recur(i+1,sum-candidates[i],candidates,temp,res);
        temp.remove(temp.size()-1);

        //Not taking the current element and avoiding duplicates
        for(int j=i+1;j<candidates.length;j++){
            if(candidates[j]!=candidates[i]){
                recur(j,sum,candidates,temp,res);
                break;
            }
        }
    }
}
