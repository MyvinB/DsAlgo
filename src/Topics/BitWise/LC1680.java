package Topics.BitWise;

public class LC1680 {

    public static void main(String[] args) {

    }

    public int concatenatedBinary(int n) {
        int MOD = 1_000_000_007;
        long sum = 0;
        for(int i=1;i<=n;i++){
            sum = ((sum<<Integer.toBinaryString(i).length())+i)%MOD;
        }
        return (int)sum;
    }
}
