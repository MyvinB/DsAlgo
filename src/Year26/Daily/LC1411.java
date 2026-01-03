package Year26.Daily;

public class LC1411 {

    public static void main(String[] args) {

    }

    public int numOfWays(int n) {
        long MOD = 1_000_000_007;
        long abc = 6;
        long aba = 6;

        for(int i=2;i<=n;i++){
            long nextAbc = (2*abc+2*aba)%MOD;
            long nextAba = (2*abc+3*aba)%MOD;

            abc = nextAbc;
            aba = nextAba;
        }

        return (int)((abc+aba)%MOD);
    }
}
