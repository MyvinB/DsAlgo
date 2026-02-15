package Year26.Contest.WC489;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Q1 {

    public static void main(String[] args) {

    }

    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<bulbs.size();i++){
            int val = bulbs.get(i);
            map.put(bulbs.get(i),map.getOrDefault(val,0)+1);
        }
        for(Integer key:map.keySet()){
            if(map.get(key)%2!=0){
                res.add(key);
            }
        }
        Collections.sort(res);
        return res;
    }
}
