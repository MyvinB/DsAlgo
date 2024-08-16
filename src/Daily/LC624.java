package Daily;

import java.util.List;

public class LC624 {

    public static void main(String[] args) {

    }

    public int maxDistance(List<List<Integer>> arrays) {
        int curMin = arrays.get(0).get(0),curMax = arrays.get(0).get(arrays.get(0).size()-1),res=0;
        for(int i=1;i<arrays.size();i++){
            int min = arrays.get(i).get(0);
            int max = arrays.get(i).get(arrays.get(i).size()-1);
            res = Math.max(res,Math.max(curMax-min,max-curMin));
            curMin = Math.min(min,curMin);
            curMax = Math.max(max,curMax);
        }
        return res;
    }
}
