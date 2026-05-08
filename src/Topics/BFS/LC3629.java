package Topics.BFS;

import java.util.*;

public class LC3629 {

    public static void main(String[] args) {

    }

    public Boolean[] buildSieve(int maxEl){
        Boolean[] isPrime = new Boolean[maxEl+1];
        Arrays.fill(isPrime,true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i=2;i*i<=maxEl;i++){
            if(isPrime[i]){
                for(int j=2;j*i<=maxEl;j++){
                    isPrime[j*i] = false;
                }
            }
        }
        return isPrime;
    }

    public int minJumps(int[] nums) {
        int n = nums.length;
        int[] visit = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> seenPrime = new HashSet<>();
        queue.add(0);
        visit[0] = 1;
        int steps = 0;

        int maxElement = 0;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            maxElement = Math.max(maxElement,nums[i]);
            ArrayList<Integer> list = map.getOrDefault(nums[i],new ArrayList<>());
            list.add(i);
            map.put(nums[i],list);
        }
        Boolean[] isPrime = buildSieve(maxElement);
        while(!queue.isEmpty()){
                int size = queue.size();
                for(int i=0;i<size;i++){
                    int idx = queue.poll();
                    if(idx==n-1){
                        return steps;
                    }
                    if(idx+1<n && visit[idx+1]!=1){
                        queue.offer(idx+1);
                        visit[idx+1] = 1;
                    }
                    if(idx-1>=0 && visit[idx-1]!=1){
                        queue.offer(idx-1);
                        visit[idx-1] = 1;
                    }

                    if(!isPrime[nums[idx]] || seenPrime.contains(nums[idx])){
                        continue;
                    }

                    for(int multiple= nums[idx]; multiple<=maxElement ; multiple+=nums[idx]){
                        if(!map.containsKey(multiple)){
                            continue;
                        }

                        for(int j:map.get(multiple)){
                            if(visit[j]==0){
                                queue.offer(j);
                                visit[j] = 1;
                            }
                        }
                    }
                    seenPrime.add(nums[idx]);
                }
                steps++;
        }
        return steps;
    }

}
