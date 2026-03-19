package Topics.Grid;

public class LC3212 {

    public static void main(String[] args) {
        char[][] test = new char[][]{{'Y','Y'},{'X','X'}};
        System.out.println(numberOfSubmatrices(test));
    }

    public static int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] matrix = new int[m][n];
        int[][] xMatrix = new int[m][n];
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='X') {
                    matrix[i][j] = 1;
                    xMatrix[i][j] = 1;
                }
                else if(grid[i][j]=='Y') matrix[i][j] = -1;
                if(j>0){
                    matrix[i][j] += matrix[i][j-1];
                    xMatrix[i][j] += xMatrix[i][j-1];
                }
                if(i>0){
                    matrix[i][j] +=matrix[i-1][j];
                    xMatrix[i][j] +=xMatrix[i-1][j];
                }
                if(i>0 && j>0){
                    matrix[i][j] -=matrix[i-1][j-1];
                    xMatrix[i][j] -=xMatrix[i-1][j-1];
                }
                if(matrix[i][j]==0 && xMatrix[i][j]>=1) count++;
            }
        }
        return count;
    }

    public static int numberOfSubmatricesOpti(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] sumX = new int[n];
        int[] sumY = new int[n];
        int count = 0;
        for(int i=0;i<m;i++){
            int rX= 0, rY = 0;
            for(int j=0;j<n;j++){
                if(grid[i][j]=='X') rX++;
                else if(grid[i][j]=='Y')rY++;
                sumX[j] += rX;
                sumY[j] += rY;
                if(sumX[j]>1 && sumY[j]==sumX[j])  count++;
            }
        }
        return count;
    }


}
