package Year26.Daily;

import java.util.TreeSet;

public class LC3013 {


    public static void main(String[] args) {

    }

    public long minimumCost(int[] nums, int k, int dist) {
        TreeSet<Integer> selected = new TreeSet<>((a,b)->{
            if(nums[a]==nums[b]) return a-b;
            return nums[a]-nums[b];
        });
        TreeSet<Integer> remaining = new TreeSet<>((a,b)->{
            if(nums[a]==nums[b]) return a-b;
            return nums[a]-nums[b];
        });
        k = k-1;
        int n = nums.length;
        long curSum = 0;
        long ans = Long.MAX_VALUE;
        long last = Math.min(dist+1,n-1);
        //Lets put all in selected
        for(int i=1;i<=last;i++){
            selected.add(i);
            curSum+=nums[i];
        }
        while(selected.size()>k){
            int idx = selected.pollLast();
            curSum-=nums[idx];
            remaining.add(idx);
        }
        ans = curSum;
        for(int r=dist+2,l=1;r<n;r++,l++){
            remaining.add(r);
            if(selected.contains(l)){
                selected.remove(l);
                curSum -= nums[l];
                int smallest = remaining.pollFirst();
                selected.add(smallest);
                curSum+=nums[smallest];
            } else {
                remaining.remove(l);
            }
            if(!remaining.isEmpty() && !selected.isEmpty() && nums[selected.last()]> nums[remaining.first()]){
                int idx = selected.pollLast();
                curSum -=nums[idx];
                remaining.add(idx);
                int idx1 = remaining.pollFirst();
                selected.add(idx1);
                curSum += nums[idx1];
            }
            ans = Math.min(ans,curSum);
        }
        return ans;
    }
}
