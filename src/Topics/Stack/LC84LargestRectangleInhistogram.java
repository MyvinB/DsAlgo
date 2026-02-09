package Topics.Stack;

import java.util.Stack;

public class LC84LargestRectangleInhistogram {

    public static void main(String[] args) {
        int[] t = new int[]{2,1,5,6,2,3};
        largestRectangleArea(t);
    }


    public static int largestRectangleArea(int[] heights) {
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
