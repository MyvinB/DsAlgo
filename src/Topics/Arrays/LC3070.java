package Topics.Arrays;

public class LC3070 {


    public static void main(String[] args) {
        int[][] t = new int[][]{{7,2,9},{1,5,0},{2,6,6}};
        System.out.println(countSubmatrices(t,20));
    }

    public static int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] matrix = new int[m][n];
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(j>0){
                    matrix[i][j] += matrix[i][j-1];
                }
                if(i>0){
                    matrix[i][j] += matrix[i-1][j];
                }
                if(i>0 && j>0){
                    matrix[i][j] -= matrix[i-1][j-1];
                }
                matrix[i][j] += grid[i][j];
                if(matrix[i][j]<=k) count++;
            }
        }
        return count;
    }
}
