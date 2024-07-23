package Daily;

import java.util.Arrays;
import java.util.HashMap;

public class LC1636 {

    public static void main(String[] args) {

    }

    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Integer[] numsArr = new Integer[nums.length];
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            numsArr[i] = nums[i];
        }
        Arrays.sort(numsArr,(a,b)->{
            if(map.get(a)==map.get(b)) return Integer.compare(b,a);
            else return map.get(a)-map.get(b);
        });
       return  Arrays.stream(numsArr).mapToInt(Integer::intValue).toArray();
    }
}
