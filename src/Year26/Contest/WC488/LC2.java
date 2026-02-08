package Year26.Contest.WC488;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class LC2 {

    public static void main(String[] args) {
        int[] t = new int[]{3,1,1,2};
        System.out.println(mergeAdjacent(t));
    }


    public static List<Long> mergeAdjacent(int[] nums) {
        Stack<Long> stack = new Stack<>();
        for(int i=0;i<nums.length;i++){
            if(!stack.isEmpty() && stack.peek()==nums[i]){
                Long newEle= nums[i]*1L;
                while(!stack.isEmpty() && Objects.equals(stack.peek(), newEle)){
                    stack.pop();
                    newEle = newEle*2L;
                }
                stack.push(newEle);
            }
            else {
                stack.push((long) nums[i]);
            }
        }
        List<Long> res = new ArrayList<>();
        for(Long el:stack){
            res.add(el);
        }
        return res;
    }
}
