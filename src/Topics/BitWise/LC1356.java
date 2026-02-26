package Topics.BitWise;

import java.util.*;

public class LC1356 {

    public static void main(String[] args) {

    }

    public int[] sortByBits(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int n = arr[i];
            int count = 0;
            while(n!=0){
                if((n&1)==1){
                    count++;
                }
                n>>=1;
            }
            map.put(arr[i],count);
        }
        Integer[] temp = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(temp,(a,b)->{
            if(map.get(a)==map.get(b)) return Integer.compare(a,b);
            return Integer.compare(map.get(a),map.get(b));
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }

        return arr;
    }
}
