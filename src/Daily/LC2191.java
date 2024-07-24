package Daily;

import java.util.Arrays;
import java.util.HashMap;

public class LC2191 {

    public static void main(String[] args) {
        int[] t = new int[]{8,9,4,0,2,1,3,5,7,6};
        int[] p = new int[]{991,338,38};
        System.out.println(Arrays.toString(sortJumbled(t,p)));
    }


    public static int[] sortJumbledNaive(int[] mapping, int[] nums) {
        Integer[] numsArr = new Integer[nums.length];
        Integer[] convertedArr = new Integer[nums.length];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            numsArr[i] = nums[i];
            String bString = String.valueOf(nums[i]);
            StringBuilder sbB = new StringBuilder();
            sbB.setLength(bString.length());
            for (int j = 0; j < bString.length(); j++) {
                int idx = Integer.parseInt(bString.charAt(j) + "");
                sbB.append(mapping[idx]);
            }
            convertedArr[i] = Integer.valueOf(sbB.toString().trim());
            map.put(nums[i],convertedArr[i]);
        }
        Arrays.sort(numsArr,(a,b)->{
            return Integer.compare(map.get(a),map.get(b));
        });
        return Arrays.stream(numsArr).mapToInt(Integer::intValue).toArray();
    }


    public static int[] sortJumbled(int[] mapping, int[] nums) {
        Integer[] numsArr = new Integer[nums.length];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            numsArr[i] = nums[i];
            int temp = nums[i];
            int mappedValue = 0;
            int place = 1;

            while(temp!=0){
                mappedValue = place*mapping[temp%10]+mappedValue;
                place=place*10;
                temp = temp/10;
            }
            map.put(nums[i],mappedValue);
        }
        Arrays.sort(numsArr,(a,b)->{
            return Integer.compare(map.get(a),map.get(b));
        });
        return Arrays.stream(numsArr).mapToInt(Integer::intValue).toArray();
    }
}
