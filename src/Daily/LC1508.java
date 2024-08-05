package Daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LC1508 {

    public static void main(String[] args) {
        int[] t = new int[]{1,2,3,4};
        System.out.println(rangeSum(t,4,1,10));
    }

    public static int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> list = new ArrayList<>();
        int preSum = 0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                preSum+=nums[j];
                list.add(preSum);
            }
            preSum = 0;
        }
        Collections.sort(list);
        int sum = 0, mod = (int) 1e9+7;
        for(int i=left;i<=right;i++){
            sum=(sum+list.get(i-1))%mod;
        }
        return sum;
    }
}
