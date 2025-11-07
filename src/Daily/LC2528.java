package Daily;

import java.util.Arrays;

public class LC2528 {

    public static void main(String[] args) {
        int[] t = new int[]{4, 4, 4, 4};
        System.out.println(maxPower(t, 0, 3));
    }


    public static boolean canAchieve(long tarP, long[] diff, int k, int r) {
        int curk = k;
        int n = diff.length - 1;
        long[] diffCopy = new long[n + 1];
        long currP = 0;
        for (int i = 0; i < n; i++) {
            currP += diffCopy[i];
            currP += diff[i];
            if (currP < tarP) {
                long additional = tarP - currP;
                if (additional > curk) return false;
                curk -= additional;
                currP += additional;
                int right = Math.min(i + 2 * r + 1, n);
                diffCopy[right] -= additional;
            }
        }
        return true;
    }

    public static long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        // first make the difference array
        long[] diffArr = new long[n + 1];
        long min = Integer.MAX_VALUE;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int left = Math.max(i - r, 0);
            int right = Math.min(i + r + 1, n);
            diffArr[left] += stations[i];
            diffArr[right] -= stations[i];
            min = Math.min(stations[i], min);
            sum += stations[i];
        }
        long low = min, high = sum + k;
        long res = low;
        // Binary Search
        while (low <= high) {
            long tarP = (low + high) / 2;
            if (canAchieve(tarP, diffArr, k, r)) {
                res = tarP;
                low = tarP + 1;
            } else {
                high = tarP - 1;
            }
        }
        return res;
    }

}


