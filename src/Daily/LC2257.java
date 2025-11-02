package Daily;

public class LC2257 {

    public static void main(String[] args) {
       System.out.println(countUnguarded(5,5,new int[][]{{1,4},{4,1},{0,3}},new int[][]{{3,2}}));

//        System.out.println(countUnguarded(4,6,new int[][]{{0,0},{1,1},{2,3}},new int[][]{{0,1},{2,2},{1,4}}));
    }

//    k=i=g[0];
//    l=j=g[1];
//            while(k<m && (mat[k][l]==0|| mat[k][l]==1) ){ mat[k++][l] = 1;}
//    //Back to guard and then move up to not count the guard
//    k=i;
//    l=j;
//    k--;
//            while(k>=0 && (mat[k][l]==0|| mat[k][l]==1)){ mat[k--][l] = 1;}
//    k=i;
//    l=j;
//            while(l<n && (mat[k][l]==0|| mat[k][l]==1)){ mat[k][l++] = 1;}
//    k=i;
//    l=j;
//            while(l>=0 && (mat[k][l]==0|| mat[k][l]==1)){ mat[k][l--] = 1;}
//    mat[i][j] = 2;

    public static int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] mat = new int[m][n];
        //Mark the walls
        for(int[] w:walls){
            mat[w[0]][w[1]] = -1;
        }
        //Mark the guards
        for(int[] g:guards) {
            int row = g[0], col = g[1];
            mat[row][col] = 2;
        }
        for(int[] g:guards){
            int row= g[0],col=g[1];
            //Down
            for(int i=row-1;i>=0;i--){
                if(mat[i][col]==-1 || mat[i][col]==2) break;
                mat[i][col] = 1;
            }
            //UP
            for(int i=row+1;i<m;i++){
                if(mat[i][col]==-1 || mat[i][col]==2) break;
                mat[i][col] = 1;
            }
            //left
            for(int j=col-1;j>=0;j--){
                if(mat[row][j]==-1 || mat[row][j]==2) break;
                mat[row][j] =1;
            }
            //right
            for(int j=col+1;j<n;j++){
                if(mat[row][j]==-1 || mat[row][j]==2) break;
                mat[row][j] =1;
            }
        }
        int res = 0;
        for(int p =0;p<m;p++){
            for(int q=0;q<n;q++){
                if(mat[p][q]==0) res++;
            }
        }
        return res;
    }

}
