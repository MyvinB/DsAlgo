package Daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LC1200 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(int i=1;i<arr.length;i++){
            int diff= arr[i] - arr[i-1];
            min=Math.min(min,diff);
        }
        for(int i=1;i<arr.length;i++){
            int diff= arr[i] - arr[i-1];
            if(diff==min){
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[i-1]);
                temp.add(arr[i]);
                res.add(temp);
            }
        }
        return res;
    }
}
