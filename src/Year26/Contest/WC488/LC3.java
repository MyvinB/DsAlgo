package Year26.Contest.WC488;

import java.util.PriorityQueue;

public class LC3 {

    public static void main(String[] args) {
        int[] t = new int[]{1,3,2};
        System.out.println(countSubarraysOpti(t,4));
    }

    public static long countSubarrays(int[] nums, long k) {
        long count = 0;
        int n = nums.length;
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for(int i=0;i<n;i++){

        }

        return count;
    }


    public static long countSubarraysOpti(int[] nums, long k) {
        long count = 0;
        int n = nums.length;
        PriorityQueue<Long> ascPq = new PriorityQueue<>();
        PriorityQueue<Long> descPq = new PriorityQueue<>((a,b)->Long.compare(b,a));

        for(int i=0;i<n;i++){
            ascPq.offer((long) nums[i]);
            descPq.offer((long) nums[i]);
            if(!descPq.isEmpty() && !ascPq.isEmpty() &&(descPq.peek()- ascPq.peek())*(-i+1)<=k) count++;
        }
        for(int j=1;j<n;j++){
            ascPq.remove((long)nums[j-1]);
            descPq.remove((long)nums[j-1]);
            if(!descPq.isEmpty() && !ascPq.isEmpty() &&(descPq.peek()- ascPq.peek())*(j-n-1+1)<=k) count++;
        }
        return count;
    }
}
