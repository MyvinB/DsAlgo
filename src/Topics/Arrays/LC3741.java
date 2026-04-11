package Topics.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC3741 {

    public static void main(String[] args) {

    }

    public int minimumDistance(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            List<Integer> temp;
            if(map.containsKey(nums[i])){
                temp = map.get(nums[i]);
            }else{
                temp = new ArrayList<>();
            }
            if(temp.size()>=2){
                int p = temp.get(temp.size()-2);
                temp.remove(temp.size()-2);
                min = Math.min(min,i-p);
            }
            temp.add(i);
            map.put(nums[i],temp);
        }
        return min==Integer.MAX_VALUE?-1:2*min;
    }
}
