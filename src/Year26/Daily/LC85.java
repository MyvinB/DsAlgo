package Year26.Daily;

import java.util.Stack;

public class LC85 {


    public static void main(String[] args) {
        char[][] t = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','0','0','1','0'},{'1','0','0','1','0'}};
        System.out.println(maximalRectangle(t));
    }

    public static int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] hist = new int[n];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]!='0'){
                    hist[j] += 1;
                } else hist[j] = 0;
            }
            int area = area(hist);
            max = Math.max(max,area);
        }
        return max;
    }

    public static int area(int[] heights) {
        int n = heights.length;
        int area = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<=n;i++){
            while(!stack.isEmpty() && (i==n||heights[stack.peek()]>heights[i])){
                int height = heights[stack.pop()];
                int width;
                if(stack.isEmpty()) width = i;
                else width = i-stack.peek()-1;
                area = Math.max(area,height*width);
            }
            stack.push(i);
        }
        return area;
    }


}

