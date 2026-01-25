package Year26.Contest.C486;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LC48Q2 {

    public static void main(String[] args) {
        int[] t = new int[]{5,4,-9,6};
        int[] t1 = new int[]{-3,-2,7};
        int[] t3 = new int[]{1,-2,3,-4};
        int[] t4 = new int[]{0};
        System.out.println(Arrays.toString(rotateElements(t,2)));
    }

    public static int[] rotateElementsNaive(int[] nums, int k) {
        if(k==0){
            return nums;
        }
        int n = nums.length;
        int[] ans = new int[n];
        HashMap<Integer,Integer> map = new HashMap<>();
        int begin = -1;
        int prevPositive = -1;
        for(int i=0;i<n;i++){
            if(begin==-1 && nums[i]>=0){
                begin = i;
                prevPositive = i;
            }
            else if(nums[i]>=0){
                map.put(prevPositive,i);
                prevPositive = i;
            }
            else ans[i] = nums[i];
        }
        //Found no positibe numbers
        if(prevPositive==-1){
            return nums;
        }
        map.put(prevPositive,begin);
        int moves = k;
        for(int t: map.keySet()){
            int val = t;
            int key = t;
            int initialVal = key;
            while(moves>0){
                val = map.get(key);
                key = val;
                moves--;
            }
            moves = k;
            ans[initialVal] = nums[val];
        }

        return ans;
    }


    public static int[] rotateElements(int[] nums, int k){
        int n= nums.length;
        List<Integer> posIndex = new ArrayList<>();
        int[] ans = new int[n];
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=0){
                posIndex.add(i);
            }else{
                ans[i] = nums[i];
            }
        }
        if(posIndex.isEmpty()) return nums;
        int m = posIndex.size();
        for(int i=0;i<posIndex.size();i++){
            int curIndex = posIndex.get(i);
            int nextIndex = posIndex.get((i+k)%m);
            ans[curIndex] = nums[nextIndex];
        }
        return ans;
    }
}
