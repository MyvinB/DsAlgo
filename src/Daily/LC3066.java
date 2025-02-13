package Daily;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class LC3066 {


    public static void main(String[] args) {
        int[] t = new int[]{97,73,5,78};
        System.out.println(minOperations(t,98));

    }

    public static int minOperations(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            pq.offer(nums[i]);
        }
        int count =0,a=0,b=0,res=0;
        while(!pq.isEmpty() && pq.peek()<k){
            a = pq.poll();
            if(pq.isEmpty()){
                break;
            }
            b = pq.poll();
            res = Math.min(a,b)+2 * Math.max(a,b);
            pq.offer(res);
            count++;
        }
        return count;

    }

}
