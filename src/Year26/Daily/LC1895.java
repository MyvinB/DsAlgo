package Year26.Daily;

public class LC1895 {

    public static void main(String[] args) {
        //[[5,1,3,1],[9,3,3,1],[1,3,3,8]]
        int[][] t = new int[][]{{5,1,3,1},{9,3,3,1},{1,3,3,8}};
        int[][] t2 = new int[][]{{8,1,6},{3,5,7},{4,9,2},{7,10,9}};

        System.out.println(largestMagicSquare(t2));
    }

    public static int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] prefixRow = new int[m][n+1];
        int[][] prefixCol = new int[m+1][n];

        //Calculate presum for row
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                prefixRow[i][j+1] = prefixRow[i][j] +grid[i][j];
                prefixCol[i+1][j] = prefixCol[i][j] + grid[i][j];
            }
        }

        int maxSize = Math.max(m,n);
        while(maxSize>=2){
            for(int i=0;i+maxSize<=m;i++){
                for(int j=0;j+maxSize<=n;j++){
                    if(check(i,j,prefixRow,prefixCol,grid,maxSize)){
                        return maxSize;
                    }
                }
            }
            maxSize--;
        }

        return 1;
    }

    public static boolean check(int row, int col, int[][] prefixRow,int[][] prefixCol, int[][] grid,int size){
        //calculating target
        int target = prefixRow[row][col+size] -prefixRow[row][col];
        for(int i=row;i<row+size;i++){
            if(prefixRow[i][col+size]-prefixRow[i][col]!=target){
                return false;
            }
        }
        for(int j=col;j<col+size;j++){
            if(prefixCol[row+size][j]-prefixCol[row][j]!=target){
                return false;
            }
        }
        int d1 = 0, d2 = 0;
        for(int i=0;i<size;i++){
            d1+=grid[row+i][col+i];
            d2+=grid[row+i][col+size-1-i];
        }
        if(d1!=target || d2!=target) return false;
        return true;
    }
}
