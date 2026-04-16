package Topics.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC3488 {

    public static void main(String[] args) {
        int[] t = new int[]{1,3,1,4,1,3,2};
        int[] q = new int[]{0,3,5};
        System.out.println(solveQueries(t,q));
    }

    public static List<Integer> solveQueries(int[] nums, int[] queries) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        int n = nums.length;
        for(int i =0;i<n;i++){
            List<Integer> temp = map.getOrDefault(nums[i],new ArrayList<>());
            temp.add(i);
            map.put(nums[i],temp);
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            int queryIndex = queries[i];
            List<Integer> temp = map.get(nums[queryIndex]);
            if(temp.size()==1){
                ans.add(-1);
                continue;
            }
            int l = 0, h = temp.size()-1;
            int val = -1;
            while(l<=h){
                int mid = l +(h-l)/2;
                if(temp.get(mid)>=queryIndex){
                    h = mid-1;
                    val = mid;
                }else{
                    l=mid+1;
                }
            }
            int size = temp.size();
            int left = temp.get((val-1+size)%size);
            int right = temp.get((val+1)%size);
            //Left ditance both direct and circular
            int distLeft = Math.min(Math.abs(queryIndex-left),n-Math.abs(queryIndex-left));
            int distRight = Math.min(Math.abs(right-queryIndex),n-Math.abs(right-queryIndex));
            ans.add(Math.min(distLeft,distRight));
        }
        return ans;
    }
}
