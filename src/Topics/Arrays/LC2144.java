package Topics.Arrays;

import java.util.Arrays;

public class LC2144 {

    public static void main(String[] args) {
        int[] t = new int[]{6,5,7,9,2,2};
        System.out.println(minimumCost(t));
    }

    public static int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int sum = 0;
        int n = cost.length;
        for(int i=0;i<n;i++){
            sum+=cost[i];
        }
        int freeSum = 0;
        for(int i=n-3;i>=0;i=i-3){
            freeSum += cost[i];
        }
        return sum-freeSum;
    }
}
