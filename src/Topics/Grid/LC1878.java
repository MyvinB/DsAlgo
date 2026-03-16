package Topics.Grid;

import java.util.*;

public class LC1878 {

    public static void main(String[] args) {
`
    }

    public int[] getBiggestThree(int[][] grid) {
        TreeSet<Integer> set = new TreeSet<>((a,b)->Integer.compare(b,a));
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                for(int k=1;;k++){
                    if(i-k<0 || i+k>=grid.length || j-k<0 || j+k>=grid[0].length){
                        break;
                    }
                    int sum =0;
                    for(int d=0;d<k;d++){
                        sum+= grid[i-k+d][j+d]; //top -> right -> b diagonal both x and y increase
                        sum+=grid[i+d][j+k-d]; //right->bottom
                        sum+=grid[i+k-d][j-d]; //bottom -> left
                        sum+=grid[i-d][j-k+d];
                    }
                    set.add(sum);
                }
                set.add(grid[i][j]);
                while(!set.isEmpty() && set.size()>3){
                    set.pollLast();
                }
            }
        }

        return set.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
