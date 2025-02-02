package DP;

public class LC45 {


    public static void main(String[] args) {

    }

    public int jump(int[] nums) {
        int l = 0,r=0,reach=0,bfsCount=0;
        int n = nums.length-1;
        while(r<n){
            for(int i=l;i<=r;i++){
                reach = Math.max(reach,i+nums[i]);
            }
            l =r+1;
            r = reach;
            bfsCount++;
        }
        return bfsCount;
    }
}
