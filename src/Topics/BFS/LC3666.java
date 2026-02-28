package Topics.BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

public class LC3666 {

    public static void main(String[] args) {
        String s ="110";
        System.out.println(minOperations(s,1));
    }

    public static int minOperations(String s, int k) {
        int zCount = 0;
        int n = s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='0'){
                zCount++;
            }
        }
        if(zCount==0){
            return 0;
        }
        // Keep track of unvisited counts. Split by parity since newZ jumps by 2.
        TreeSet<Integer> evens = new TreeSet<>();
        TreeSet<Integer> odds = new TreeSet<>();
        for(int i=0;i<=n;i++){
            if(i!=zCount){
                if(i%2==0){
                    evens.add(i);
                }else{
                    odds.add(i);
                }
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(zCount);
        int[] operation = new int[n+1];
        Arrays.fill(operation,-1);
        operation[zCount] = 0;
        while(!queue.isEmpty()){
            int Z = queue.poll();
            int maxF =  Math.min(Z,k);
            int minF = Math.max(0,k-n+Z);
            // Calculate the absolute lowest and highest possible newZ
            // (Note: maxF creates the minimum newZ, minF creates the maximum newZ)
            int minNewZ = Z + k - 2 * maxF;
            int maxNewZ = Z + k - 2 * minF;

            // Pick the right set based on the parity of minNewZ
            TreeSet<Integer> targetSet = (minNewZ % 2 == 0) ? evens : odds;

            Integer curr = targetSet.ceiling(minNewZ);

            // Jump through ONLY the unvisited numbers in our range
            while (curr != null && curr <= maxNewZ) {
                operation[curr] = operation[Z] + 1;
                if (curr == 0) return operation[curr];

                queue.add(curr);

                // Remove it so we never waste time iterating over it again
                targetSet.remove(curr);

                // Get the next valid unvisited number
                curr = targetSet.ceiling(curr + 1);
            }
        }
        return -1;
    }
}
