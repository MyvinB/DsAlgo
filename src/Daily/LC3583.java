package Daily;

import java.util.HashMap;

public class LC3583 {

    public static void main(String[] args) {
        int[] t = new int[]{0,1,0,0};
        int[] p = new int[]{37,9,24,12,12,24,52,35};
        System.out.println(specialTriplets(t));
    }

    public static int specialTriplets(int[] nums) {
        final int MOD = 1000000007;
        HashMap<Integer,Integer> map = new HashMap<>();
        HashMap<Integer,Integer> curMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int total = 0;
        for(int i=0;i<nums.length;i++){
            int target = nums[i] *2;
            int left = curMap.getOrDefault(target,0);
            curMap.put(nums[i],curMap.getOrDefault(nums[i],0)+1);
            int right = map.getOrDefault(target,0)-curMap.getOrDefault(target,0);
            total = (total + left*right)%MOD;
        }
        return total;
    }
}
