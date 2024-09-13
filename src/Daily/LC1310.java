package Daily;

import java.util.ArrayList;
import java.util.Arrays;

public class LC1310 {

    public static void main(String[] args) {

    }

    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] preSumXOR  = new int[n];
        preSumXOR[0] = arr[0];
        for(int i=1;i<n;i++){
            preSumXOR[i] = preSumXOR[i-1] ^ arr[i];
        }
        int res[] = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int[] idx = queries[i];
            if(idx[0]==idx[1]){
                res[i] = arr[idx[1]];
            }
            else if(idx[0] == 0){
                res[i] = preSumXOR[idx[1]];
            }
            else {
                res[i] = preSumXOR[idx[1]] ^ preSumXOR[idx[0]-1];
            }
        }
        return res;
    }

}
