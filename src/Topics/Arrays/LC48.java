package Topics.Arrays;

import java.util.Arrays;

public class LC48 {

    public static void main(String[] args) {
        int[][] t = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(t);
        Arrays.deepToString(t);
    }
/*
* [
[1,2,3], [1,4,7] [7,4,1]
[4,5,6], [2,5,8] [8,5,2]
[7,8,9]] [3,6,9] [9,6,3]
*
* */
    public static void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        //Transpose done first
        for(int i=0;i<m;i++){
            for(int j=i+1;j<n;j++){
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

        //Reverse the matrix
        for(int i=0;i<m;i++){
            for(int j=0;j<n/2;j++){
                int temp = matrix[i][n-1-j];
                matrix[i][n-1-j] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

    }
}
