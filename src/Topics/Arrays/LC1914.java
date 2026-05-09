package Topics.Arrays;

import java.util.ArrayList;
import java.util.List;

public class LC1914 {

    public static void main(String[] args) {
        int[][] grid  = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        rotateGrid(grid,2);
    }

    public static int[][] rotateGrid(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;

        int top = 0;
        int bottom = rows - 1;
        int left = 0;
        int right = cols - 1;

        while (top < bottom && left < right) {

            List<Integer> list = new ArrayList<>();

            // left column
            for (int i = top; i <= bottom; i++) {
                list.add(grid[i][left]);
            }

            // bottom row
            for (int j = left + 1; j <= right; j++) {
                list.add(grid[bottom][j]);
            }

            // right column
            for (int i = bottom - 1; i >= top; i--) {
                list.add(grid[i][right]);
            }

            // top row
            for (int j = right - 1; j >= left + 1; j--) {
                list.add(grid[top][j]);
            }

            int size = list.size();

            int effectiveK = k % size;

            List<Integer> rotated = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                rotated.add(list.get((i - effectiveK + size) % size));
            }
            int idx = 0;

            // fill left column
            for (int i = top; i <= bottom; i++) {
                grid[i][left] = rotated.get(idx++);
            }

            // fill bottom row
            for (int j = left + 1; j <= right; j++) {
                grid[bottom][j] = rotated.get(idx++);
            }

            // fill right column
            for (int i = bottom - 1; i >= top; i--) {
                grid[i][right] = rotated.get(idx++);
            }

            // fill top row
            for (int j = right - 1; j >= left + 1; j--) {
                grid[top][j] = rotated.get(idx++);
            }

            top++;
            bottom--;
            left++;
            right--;
        }

        return grid;
    }

}
