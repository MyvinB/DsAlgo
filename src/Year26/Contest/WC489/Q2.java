package Year26.Contest.WC489;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Q2 {

    public static void main(String[] args) {
        int[] t = new int[]{20,10,30,30};
        System.out.println(firstUniqueFreq(t));
    }



    public static int firstUniqueFreq(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        HashMap<Integer, List<Integer>> map1 = new HashMap<>();
        for(int key :map.keySet()){
            int val = map.get(key);
            List<Integer> temp = map1.getOrDefault(val,new ArrayList<>());
            temp.add(key);
            map1.put(val,temp);
        }
        for(int i=0;i<nums.length;i++){
            int count = map.get(nums[i]);
            if(map1.get(count).size()==1){
                return nums[i];
            }
        }
        return -1;
    }
}
