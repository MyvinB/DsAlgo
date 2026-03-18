package Topics.Arrays;

import java.util.Arrays;
import java.util.Collections;

public class LC1727 {


    public static void main(String[] args) {

    }

    public int largestSubmatrix(int[][] matrix) {
        int n = matrix[0].length;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(i>0 && matrix[i][j]==1)
                matrix[i][j] += matrix[i-1][j];
            }
        }
        int res = 0;
        //count of element from j to n-1 is n-1-j+1 wo n-j
        //say it was sorted in reverse order ie des it would be 0-j which j-0+1 which is j+1 number of elemenets
        for(int i=0;i<matrix.length;i++){
            Arrays.sort(matrix[i]);
            for(int j=0;j<matrix[i].length;j++){
                res = Math.max(res,matrix[i][j]*(n-j));
            }
        }
        return res;
    }
}
