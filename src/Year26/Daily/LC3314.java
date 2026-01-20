package Year26.Daily;

import java.util.List;

public class LC3314 {


    public static void main(String[] args) {

    }

    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] t = new int[n];
        for(int i=0;i<n;i++){
            int element = nums.get(i);
            if(element==2)t[i] = -1;
            else{
                int mask = ~(((element+1)&~element)>>1);
                t[i]=element&mask;
            }
        }
        return t;
    }

}
