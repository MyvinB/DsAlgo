package Topics.Arrays;

public class LC3740 {

    public static void main(String[] args) {

    }

    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int ans = n+1;
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                if(nums[i]!=nums[j]){
                    continue;
                }
                for(int k=j+1;k<n;k++){
                    if(nums[k]==nums[i]){
                        ans = Math.max(ans,k-i);
                        break;
                    }
                }
            }
        }
        return ans==n+1?-1:ans*2;
    }
}
