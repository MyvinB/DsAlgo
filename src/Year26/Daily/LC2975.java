package Year26.Daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC2975 {

    public static void main(String[] args) {
        int[] t = new int[]{2};
        int[] p = new int[]{4};
        System.out.println(maximizeSquareArea(6,7,t,p));
    }

    public static int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        Arrays.sort(hFences);
        Arrays.sort(vFences);
        Set<Integer> set = new HashSet<>();
        int hLen = hFences.length;
        int vLen = vFences.length;
        int maxDiff = 0;
        int[] hArr = new int[hLen+2];
        int[] vArr = new int[vLen+2];
        hArr[0] = 1;vArr[0] = 1;
        hArr[hArr.length-1] = m;
        vArr[vArr.length-1] = n;
        for(int i=0;i<hLen;i++){
            hArr[i+1] = hFences[i];
        }
        for(int i=0;i<vLen;i++){
            vArr[i+1] = vFences[i];
        }
        for(int i=0;i<hArr.length;i++) {
            for (int j = i + 1; j < hArr.length; j++) {
                int diff = hArr[j] - hArr[i];
                set.add(diff);
            }
        }

        for(int i=0;i<vArr.length;i++){
            for(int j=i+1;j<vArr.length;j++){
                int diff = vArr[j] - vArr[i];
                if(set.contains(diff)){
                    maxDiff = Math.max(maxDiff,diff);
                }
            }
        }
        long mod = 1_000_000_007;
        return maxDiff==0?-1:(int)((1L*maxDiff*maxDiff)%mod);
    }
}
