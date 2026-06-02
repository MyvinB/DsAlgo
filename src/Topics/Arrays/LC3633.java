package Topics.Arrays;

public class LC3633 {

    public static void main(String[] args) {

        int[] landStartTime = new int[]{2,8};
        int[] landDuration = new int[]{4,1};
        int[] waterStartTime = new int[]{6};
        int[] waterDuration = new int[]{3};
        System.out.println(earliestFinishTime(landStartTime,landDuration,waterStartTime,waterDuration));
    }

    public static int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int res = 3000;
        int minL = 3000;
        int minW = 3000;
        for(int i=0;i<landStartTime.length;i++) {
            minL = Math.min(minL,landStartTime[i]+landDuration[i]);
        }

        for(int i=0;i<waterStartTime.length;i++){
            minW = Math.min(minW,waterStartTime[i]+waterDuration[i]);
            res = Math.min(res,Math.max(minL,waterStartTime[i])+waterDuration[i]);
        }

        for(int i=0;i<landStartTime.length;i++){
            res = Math.min(res,Math.max(minW,landStartTime[i])+landDuration[i]);
        }

        return res;
    }
}
