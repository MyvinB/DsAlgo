package Graph;

public class LC200NumberOfIslands {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!='0'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }

    private   int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};



    public void dfs(char[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        if(i<0||j<0||i>=m||j>=n || grid[i][j] !='1') return;
        grid[i][j] = '0';
        for(int[] d:dir){
            dfs(grid,i+d[0],j+d[1]);
        }
    }
}
