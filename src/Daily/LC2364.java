package Daily;

import java.util.HashMap;

public class LC2364 {


    public static void main(String[] args) {
        int[] t = new int[]{43,69,66,40,33};
        System.out.println(countBadPairs(t));
    }




    public static long countBadPairs(int[] nums) {
        int n = nums.length;
        long total = ((long)(n-1)*n)/2;
        long lhs = 0, rhs = 0;
        long gCount = 0;
        //find good pairs

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int goodPair = map.getOrDefault(i-nums[i],0);
            if(goodPair!=0){
                gCount+=goodPair;
            }
            map.put(i-nums[i],goodPair+1);
        }


        return total-gCount;
    }
}
