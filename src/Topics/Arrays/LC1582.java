package Topics.Arrays;

import java.util.HashSet;

public class LC1582 {

    public static void main(String[] args) {

    }

    public int numSpecial(int[][] mat) {
        //First calculate the row 1s
        int n = mat.length;
        int m = mat[0].length;
        int[] row = new int[n];
        int[] col = new int[m];
        //Row calculation
        for(int i=0;i<n;i++){
            int val =-1;
            for(int j=0;j<m;j++){
                if(val!=-1 && mat[i][j]==1){
                    val=-1;
                    break;
                }
                if(mat[i][j]==1){
                    val = j;
                }
            }
            row[i] = val;
        }
        //Column Calculation
        for(int j=0;j<m;j++){
            int val =-1;
            for(int i=0;i<n;i++){
                if(val!=-1 && mat[i][j]==1){
                    val=-1;
                    break;
                }
                if(mat[i][j]==1){
                    val = i;
                }
            }
            col[j] = val;
        }
        int count = 0;
        for(int i=0;i<n;i++){
            if(row[i]!=-1 && col[row[i]]==i){
                count++;
            }
        }
        return count;
    }
}
