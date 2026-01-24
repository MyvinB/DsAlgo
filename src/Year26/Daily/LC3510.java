package Year26.Daily;

import java.util.TreeSet;

public class LC3510 {

    static class Pair implements Comparable<Pair>{
        int idx;
        long val;
        long sum;
        Pair left;
        Pair right;

        Pair(int idx,int val){
            this.idx = idx;
            this.val = val;
        }
        @Override
        public int compareTo(Pair p) {
            if(this.right==null && p.right==null){
                return this.idx - p.idx;
            }
            if(this.right==null) return 1;
            if(p.right==null) return -1;

            long diff = this.sum - p.sum;
            return diff!=0?(diff<0?-1:1):this.idx-p.idx;

        }
    }






    public static int minimumPairRemoval(int[] nums) {
        TreeSet<Pair> set = new TreeSet<>();
        int misMatches = 0;
        Pair prev = null;
        for(int i=0;i<nums.length;i++){
            Pair cur = new Pair(i,nums[i]);
            if(prev==null){
                prev = cur;
            } else{
                if(cur.val<prev.val) misMatches++;
                prev.right = cur;
                cur.left= prev;
                prev.sum = prev.val + cur.val;
                set.add(prev);
                prev = cur;
            }
        }
        set.add(prev);
        int count = 0;
        while(misMatches>0){
            Pair best = set.pollFirst();
            if(best.right.val<best.val) misMatches--;
            long newVal = best.val + best.right.val;
            best.val = newVal;
            Pair  del = best.right;
            best.right = del.right;
            if(del.right!=null){
                best.sum = best.val + del.right.val;
                if(del.right.val<del.val) misMatches--;
                del.right.left = best;
                if(best.val>del.right.val) misMatches++;
            }
            set.remove(del);
            set.add(best);
            Pair left = best.left;
            if(left!=null){
                set.remove(left);
                long oldRightVal = left.sum - left.val;
                if(left.val > oldRightVal) misMatches--;
                if(left.val>best.val) misMatches++;
                left.sum = left.val + best.val;
                left.right = best;
                set.add(left);
            }
            count++;
        }

        return count;
    }


    public static void main(String[] args) {
        int[] t = new int[]{2,2,-1,3,-2,2,1,1,1,0,-1};
        System.out.println(minimumPairRemoval(t));
    }
}
