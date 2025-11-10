package Daily;

import java.util.Stack;

public class LC3542 {

    public static void main(String[] args) {
        int[] t = new int[]{3, 1, 2, 1};
        int[] f = new int[]{1,2,1,2,1,2};
        int[] e = new int[]{0,2};
        System.out.println(minOperations(e));

    }

    public static int minOperations(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && stack.peek() > nums[i]) {
                stack.pop();
            }
            if(nums[i]==0){
                continue;
            }
            if (stack.isEmpty() || (!stack.isEmpty() && stack.peek() < nums[i])) {
                stack.push(nums[i]);
                count++;
            }
        }
        return count;
    }

}
