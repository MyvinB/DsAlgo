package Topics.SlidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC3835 {

    public static void main(String[] args) {

    }

    public static long countSubarraysBest(int[] nums, long k) {
        long ans = 0, j = 0, n = nums.length;
        Deque<Integer> mx = new ArrayDeque<>(); //Decreasing monotonic stack
        Deque<Integer> mn = new ArrayDeque<>(); //Increasing Monotonic stack

        for(int i=0;i<n;i++){
            while(!mx.isEmpty() && nums[mx.peekLast()]<=nums[i]) mx.pollLast();
            while(!mn.isEmpty() && nums[mn.peekLast()]>=nums[i]) mn.pollLast();
            mx.offer(i);
            mn.offer(i);
            while(j<=i && (long)(nums[mx.peekFirst()]-nums[mn.peekFirst()])*(i-j+1)>k){
                if(mx.peekFirst()==j)mx.pollFirst();
                if(mn.peekFirst()==j)mn.pollFirst();
                j++;
            }
            ans+=i-j+1;
        }
        return ans;
    }
}
