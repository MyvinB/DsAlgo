package Daily;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by myvinbarboza on 24/04/25 at 1:01 PM
 * Today is a Thursday
 */
public class LC2799 {

    public static void main(String[] args) {
        int[] t = new int[]{5,5,5,5};
        System.out.println(countCompleteSubarrays(t));
    }

    public static int countCompleteSubarrays(int[] nums) {
        int k = (int)Arrays.stream(nums).distinct().count();
        int left = 0,res = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            while(map.size()==k){
                res +=nums.length-i;
                map.put(nums[left],map.get(nums[left])-1);
                if(map.get(nums[left])==0) map.remove(nums[left]);
                left++;
            }
        }
        return res;
    }
}
