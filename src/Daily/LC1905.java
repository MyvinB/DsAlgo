package Daily;

public class LC1905 {

    public static void main(String[] args) {
        int[][] grid1 = {{1,1,1,0,0},{0,1,1,1,1},{0,0,0,0,0},{1,0,0,0,0},{1,1,0,1,1}};
        int[][] grid2 = {{1,1,1,0,0},{0,0,1,1,1},{0,1,0,0,0},{1,0,1,1,0},{0,1,0,1,0}};
        System.out.println(countSubIslands(grid1,grid2));
    }


    public static int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        Boolean[] isSubIsland = new Boolean[]{true};
        int cnt = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid2[i][j]==1){
                    isSubIsland[0] = true;
                    dfs(i,j,grid1,grid2,isSubIsland);
                    if(isSubIsland[0]){
                        cnt++;
                    }

                }
            }
        }
        return cnt;
    }

    static int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public static void dfs(int i,int j, int[][] grid1,int[][] grid2, Boolean[] isSubIsland){
        int m = grid2.length;
        int n = grid2[0].length;
        if(i<0 ||i>=m || j<0 || j>=n || grid2[i][j]==0) return;
        if(grid1[i][j]!=grid2[i][j]){
            isSubIsland[0] = false;
        }
        grid2[i][j] = 0;
        for(int[] d:dir){
            dfs(i+d[0],j+d[1],grid1,grid2,isSubIsland);
        }
    }
}
