package Daily;

/**
 * Created by myvinbarboza on 22/04/25 at 12:17 PM
 * Today is a Tuesday
 */
public class LC2338 {
    private static final int mod = (int)1e9 + 7;
    private long[][] count;
    private long[][] prefixSum;
    private long[] options;

    private void countOptions(int cur,int idx,int maxValue){
        options[idx]++;
        for(int j=2;cur*j<=maxValue;j++){
            countOptions(cur*j,idx+1,maxValue);
        }
    }

    public int idealArrays(int n, int maxValue) {
        count = new long[15][10005];
        prefixSum = new long[15][10005];
        options = new long[15];

        //prfilling first row
        for(int i=1;i<=10000;i++){
            count[1][i] = 1;
            prefixSum[1][i] = i;
        }

        for(int i=2;i<=14;i++){
            for(int j=i;j<=10000;j++){
                count[i][j] = prefixSum[i-1][j-1];
                prefixSum[i][j] = (count[i][j]+prefixSum[i][j-1])%mod;
                count[i][j] %=mod;
            }
        }

        for(int i=1;i<=maxValue;i++){
            countOptions(i,1,maxValue);
        }
        long ans = 0;
        for(int i=1;i<=14;i++){
            long ways = (count[i][n]* options[i])%mod;
            ans = (ans +ways)%mod;
        }
        return (int) ans;

    }

}
