package Daily;

public class LC1752 {


    public static void main(String[] args) {
        int[] t = new int[]{3,4,5,1,2};
    }

    public boolean check(int[] nums) {
        //time:25min
        int n = nums.length;
        int fault = 0;
        int maxima = nums[0];
        if(n==1) return true;
        for(int i=1;i<n;i++){
            if(nums[i]<nums[i-1]){
                fault++;
            }
        }
        if(nums[0]<nums[n-1]){
            fault++;
        }
        if(fault<=1) return true;
        return false;
    }
}
