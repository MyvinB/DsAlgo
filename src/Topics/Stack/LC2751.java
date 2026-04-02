package Topics.Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LC2751 {

    public static void main(String[] args) {
        int[] pos = new int[]{5,4,3,2,1};
        int[] health = new int[]{2,17,9,15,10};
        String dir = "RRRRR";
        int[] pos1 = new int[]{3,47};
        int[] health1 = new int[]{46,26};
        String dir1 = "LR";
        System.out.println(survivedRobotsHealths(pos1,health1,dir1));
    }


    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Stack<Integer> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        Integer[] index = new Integer[n];


        for(int i=0;i<n;i++){
            index[i] = i;
        }
        Arrays.sort(index,(a,b)->Integer.compare(positions[a],positions[b]));

        for(int idx:index){
            if(directions.charAt(idx)=='R'){
                stack.push(idx);
            }else{
                while(!stack.isEmpty() && healths[idx]>0){
                    int topIdx = stack.pop();
                    if(healths[topIdx]<healths[idx]){
                        healths[topIdx] = 0;
                        healths[idx] -=1;
                    }else if(healths[topIdx]>healths[idx]){
                        healths[topIdx] -=1;
                        healths[idx] = 0;
                        stack.push(topIdx);
                    }else{
                        healths[idx] = 0;
                        healths[topIdx] = 0;
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            if(healths[i]>0)res.add(healths[i]);
        }
        return res;
    }
}
