package Year26.Contest.WeeklyLC487;

import java.util.ArrayList;
import java.util.List;

public class LCQ2 {

    public static void main(String[] args) {
        int[] t = new int[]{3,1};
        System.out.println(finalElement(t));
    }

    public static int finalElement(int[] nums) {
        int m = nums.length;
        List<Integer> temp = new ArrayList<>();
        for(int i =0;i<m;i++){
           temp.add(nums[i]);
        }
        int l=0;
        int r=m-1;
        int turn = 1;
        while(temp.size()>1){
            while(l<r){
                if(r+1<m+l){
                    break;
                } else if(r+1>=m+l){
                    r--;
                }
            }
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int minIndex = -1;
            int maxIndex = -1;
            for(int i=l;i<=r;i++){
                int ele = temp.get(i);
                if(ele<=min){
                    minIndex = i;
                    min = ele;
                }
                if(ele>=max){
                    maxIndex = i;
                    max = ele;
                }
            }
            if(turn==1){
                temp.remove(maxIndex);
                turn = 0;
            } else{
                temp.remove(minIndex);
                turn = 1;
            }
            m = temp.size();
            l = 0;
            r = m-1;
        }
        return temp.get(0);
    }
}
