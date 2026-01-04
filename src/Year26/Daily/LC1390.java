package Year26.Daily;

import java.util.HashMap;

public class LC1390 {

    public static void main(String[] args) {
        int[] t = new int[]{1,2,3,4,5};
    }

    public int sumFourDivisors(int[] nums) {
        int total = 0;
        for(int i=0;i<nums.length;i++){
           total+=sumIfFour(nums[i]);
        }
        return total;
    }



    private int sumIfFour(int n){
        int d1 =0,d2=0;
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                if(d1==0){
                    d1=i;
                    d2=n/i;
                }else{
                    //Suppose it comes again you return zero
                    return 0;
                }
            }
        }

        if(d1==0) return 0;
        if(d1==d2) return 0; //64 is 8 8 1 64 which is only 8 1 and 64
        return d1+d2+1+n;
    }
}
