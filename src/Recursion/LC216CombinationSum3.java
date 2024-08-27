package Recursion;

import java.util.ArrayList;
import java.util.List;

public class LC216CombinationSum3 {


    public static void main(String[] args) {
        System.out.println(combinationSum3(4,1));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        int[] t = new int[]{1,2,3,4,5,6,7,8,9};
        List<List<Integer>> res = new ArrayList<>();
        recur(0,n,k,t,new ArrayList<>(),res);
        return res;
    }

    public static void recur(int i,int sum,int k, int[] candidates, List<Integer> temp,List<List<Integer>> res){
        if(sum==0 && k==0){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(sum<0||k<0 ||i==candidates.length){
            return;
        }
        //Choosing the element
        temp.add(candidates[i]);
        recur(i+1,sum-candidates[i],k-1,candidates,temp,res);
        temp.remove(temp.size()-1);

        //Not choosing the index
        recur(i+1,sum,k,candidates,temp,res);
    }
}
