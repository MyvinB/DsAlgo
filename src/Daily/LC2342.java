package Daily;

import java.util.HashMap;

public class LC2342 {

    public static void main(String[] args) {
        int[] t = new int[]{18,43,36,13,7};
        System.out.println(maximumSum(t));
    }

    private static int getSum(int t){
        int res = 0;
        while(t!=0){
            res += t%10;
            t =t/10;
        }
        return res;
    }

    public static int maximumSum(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = -1;
        for(int i=0;i<nums.length;i++){
            int sum = getSum(nums[i]);
            if(map.containsKey(sum)){
                max = Math.max(max,nums[i]+map.get(sum));
                map.put(sum,Math.max(map.get(sum),nums[i]));
            }else{
                map.put(sum,nums[i]);
            }
        }
        return max;

    }
}
