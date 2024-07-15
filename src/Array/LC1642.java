package Array;

import java.util.Collections;
import java.util.PriorityQueue;

public class LC1642 {


    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int i=0;
        for(;i<heights.length-1;i++){
            int diff = heights[i+1]-heights[i];
            if(diff>0){
                if(bricks>=diff){
                    bricks = bricks-diff;
                    pq.offer(diff);
                }
                else if(ladders>0){
                    if(!pq.isEmpty() && pq.peek()>diff){
                        bricks = bricks +pq.poll() -diff;
                        pq.offer(diff);
                        ladders--;
                    }else{
                        ladders--;
                    }
                }
                else{
                    break;
                }
            }
        }
        return i;
    }
}

