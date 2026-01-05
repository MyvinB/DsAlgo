package Year26.Daily;

public class LC1975 {

    public static void main(String[] args) {
        int[][] t = new int[][]{{1,2,3},{-1,-2,-3},{1,2,3}};
        int[][] ta = new int[][]{{-1,0,-1},{-2,1,3},{3,2,2}};
        System.out.println(maxMatrixSum(ta));
    }

    public static long maxMatrixSum(int[][] matrix) {
        int negativeCount = 0;
        int min = Integer.MAX_VALUE;
        long total = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]<0){
                    negativeCount++;
                }
                total += Math.abs(matrix[i][j]);
                min = Math.min(min,Math.abs(matrix[i][j]));
            }
        }
        if(negativeCount%2==0) return total;
        else return total-2*min;
    }
}
