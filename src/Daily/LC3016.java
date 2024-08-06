package Daily;

import java.util.*;

public class LC3016 {


    public static void main(String[] args) {

    }

    public int minimumPushes(String word) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<word.length();i++){
            map.put(word.charAt(i),map.getOrDefault(word.charAt(i),0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        pq.addAll(map.values());
        int idx = 0,totalPushes= 0;
        while(!pq.isEmpty()){
            totalPushes += (idx/8+1)*pq.poll();
            idx++;
        }
        return totalPushes;

    }
}
