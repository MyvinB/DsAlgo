package Year26.Contest.BiWeekly175;

import java.net.Inet4Address;
import java.util.Arrays;

public class LCQ2 {

    public static void main(String[] args) {
        int[] t = new int[]{4,4,4,4};
        System.out.println(minimumK(t));
    }

    public static int minimumK(int[] nums) {
        int n = nums.length;
        for(int i=1;i<100000;i++){
            int sum = 0;
            for(int j=0;j<n;j++){
                sum += (int) Math.ceil((float)nums[j]/(float)i);
            }
            if(sum<=i*i) return i;
        }
        return -1;
    }
}
