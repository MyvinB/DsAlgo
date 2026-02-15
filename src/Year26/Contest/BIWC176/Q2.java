package Year26.Contest.BIWC176;

import java.util.HashMap;
import java.util.HashSet;

public class Q2 {

    public static void main(String[] args) {
        String[] s = new String[]{"apple","apply","banana","bandit"};
        prefixConnected(s,2);
    }

    public static int prefixConnected(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        for(String word:words){
            if(word.length()>=k){
                String s = word.substring(0,k);
                map.put(s,map.getOrDefault(s,0)+1);
            }
        }
        int count = 0;
        for(String key:map.keySet()){
            if(map.get(key)>1) count++;
        }
        return count;
    }
}
