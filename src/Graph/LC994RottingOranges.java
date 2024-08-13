package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class LC994RottingOranges {



    public static void main(String[] args) {
    /*
        0 representing an empty cell,
        1 representing a fresh orange, or
        2 representing a rotten orange.
    */
    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int freshOranges = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    queue.add(new int[]{i,j});
                }else if(grid[i][j]==1) freshOranges++;
            }
        }
        int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int time = 0;
        // Think of the last fresh orange its rotten and put in the queue but since there are no more fresh oranges why bother iterating and increasing the minute count
        while(!queue.isEmpty() && freshOranges>0){
            //For every level the minuite is increasing
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] node = queue.poll();
                for(int[] d:dir){
                    int x = d[0]+node[0];
                    int y = d[1]+node[1];
                    //if it passes boundaries and is empty or already rotten we do not consider it
                    if(x<0 || y<0 ||x>=m || y>=n|| grid[x][y]==2 || grid[x][y]==0) continue;
                    //Rotting the levels we have
                    grid[x][y]=2;
                    //Decrementing fresh orange count
                    freshOranges--;
                    queue.add(new int[]{x,y});
                }
            }
            time++;

        }
        return freshOranges==0?time:-1;
    }



}
