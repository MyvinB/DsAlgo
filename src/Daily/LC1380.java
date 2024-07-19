package Daily;

import java.nio.charset.IllegalCharsetNameException;
import java.util.*;

public class LC1380 {

    public static void main(String[] args) {
        int[][] t = new int[][]{{7,8},{1,2}};
        System.out.println(luckyNumbers(t));
    }
    /*
    * [3,7,8],
    * [9,11,13],
    * [15,16,17]
    *
    * */

    public static List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<m;i++){
            int min = Integer.MAX_VALUE;
            for(int j=0;j<n;j++){
               int ele= matrix[i][j];
               min = Math.min(min,ele);
            }
            set.add(min);
        }

        for(int i=0;i<n;i++){
            int max = Integer.MIN_VALUE;
            for(int j=0;j<m;j++){
                int ele= matrix[j][i];
                max = Math.max(max,ele);
            }
            if(set.contains(max)) res.add(max);
        }
        return res;
    }
}
