package Daily;

import java.util.*;

public class LC3318 {

    public static void main(String[] args) {
        int[] t = new int[]{9,2,2};
        System.out.println(Arrays.toString(findXSum(t,3,3)));
    }

    public static int[] findXSum(int[] nums, int k, int x) {
        int n =nums.length;
        int[] res = new int[n-k+1];
        for(int i =0;i+k-1<n;i++){
            res[i] = calSubArraySum(nums,i,i+k-1,x);
        }
        return res;
    }

    public static int calSubArraySum(int[] nums,int start, int end,int x){
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i =start;i<=end;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(int k:map.keySet()){
            if(!list.contains(k)){
                list.add(k);
            }
        }
        list.sort((a,b)->map.get(a)==map.get(b)?b-a:map.get(b)-map.get(a));
        for(int i=0;i<x && i<list.size();i++){
            int val = list.get(i);
            sum+=(val*map.get(val));
        }
        return sum;
    }
}
