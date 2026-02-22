package Topics.BitWise;

public class LC868 {

    public static void main(String[] args) {
        System.out.println(binaryGap(8));
    }

    public static int binaryGap(int n) {
        int idx = 0;
        int max = 0;
        int prevOne = Integer.MAX_VALUE;
        while(n!=0){
            if((n&1)==1){
                max = Math.max(max,idx-prevOne);
                prevOne = idx;
            }
            n>>=1;
            idx++;
        }
        return max;
    }
}
