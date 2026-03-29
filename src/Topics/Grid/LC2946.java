package Topics.Grid;

import java.util.HashSet;

public class LC2946 {

    public static void main(String[] args) {
        int[][] t = new int[][]{{1,2,1,2},{5,5,5,5},{6,3,6,3}};
        int[][] p = new int[][]{{1,2}};
        System.out.println(areSimilar(p,1));
    }
        //[[1,2]]
        public static boolean areSimilar(int[][] mat, int k) {
            int m = mat.length;
            int n = mat[0].length;
            k = k%n;
            for (int i = 0; i < m ; i++) {
                for (int j = 0; j < n; j++) {
                    int rotatedVal = mat[i][(j+k)%n];
                    if(mat[i][j] !=rotatedVal) return false;
                }
            }
            return true;
        }
}
