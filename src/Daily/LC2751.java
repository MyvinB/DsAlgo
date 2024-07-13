package Daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LC2751 {


    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Stack<Integer> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        Integer index[] = new Integer[n];
        //Filling with indexs
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
                        healths[topIdx]=0;
                        healths[idx]-=1;
                    }else if(healths[topIdx]>healths[idx]){
                        healths[topIdx]-=1;
                        healths[idx] = 0;
                        stack.push(topIdx);
                    }else{
                        healths[topIdx]=0;
                        healths[idx]=0;
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
