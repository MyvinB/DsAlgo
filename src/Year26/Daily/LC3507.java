package Year26.Daily;

import java.util.ArrayList;
import java.util.List;

public class LC3507 {

    public static void main(String[] args) {
        int[] t = new int[]{3,6,4,-6,2,-4,5,-7,-3,6,3,-4};
        System.out.println(minimumPairRemoval(t));
    }

    public static int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i< nums.length;i++){
            list.add(nums[i]);
        }
        int isDecreasing = 1;
        int idx = -1;
        int count = 0;

        while(isDecreasing==1){
            int min = Integer.MAX_VALUE;
            int decreaseCheck = 0;
            for(int i=list.size()-1;i>0;i--){
                int sum = list.get(i)+list.get(i-1);
                if(list.get(i)<list.get(i-1)){
                    decreaseCheck = 1;
                }
                if(sum<=min){
                    min = sum;
                    idx = i;
                }
            }
            if(idx!=-1 && decreaseCheck == 1 ){
                count++;
                list.remove(idx);
                list.remove(idx-1);
                list.add(idx-1,min);
            }
            if(decreaseCheck==1){
                isDecreasing = 1;
            } else{
                isDecreasing = 0;
            }
        }
        return count;
    }
}
