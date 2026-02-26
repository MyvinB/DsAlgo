package Topics.DP;

import java.util.HashMap;

public class LC3850 {

    public static void main(String[] args) {

        System.out.println(gcd(12,18));
    }

    public int countSequences(int[] nums, long k) {
        HashMap<String,Integer> dp = new HashMap();
        return solve(nums,k,1L,1L,0,dp);
    }

    public int solve(int[] nums,long k,long num,long den,int index,HashMap<String,Integer> dp){
        if(index==nums.length){
            return num == k*den?1:0;
        }
        long g = gcd(num,den);
        num /=g;
        den /=g;
        String key = num+" "+den+" "+index;
        if(dp.containsKey(key)){
            return dp.get(key);
        }
        int count = 0;
        ///Multiply
        count+= solve(nums,k,num*nums[index],den,index+1,dp);
        //Divide
        count+= solve(nums,k,num,den*nums[index],index+1,dp);
        //do Nothing
        count+= solve(nums,k,num,den,index+1,dp);

        dp.put(key,count);
        return count;
    }

    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
