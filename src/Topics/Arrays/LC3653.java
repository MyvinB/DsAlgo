package Topics.Arrays;

public class LC3653 {

    public static void main(String[] args) {

    }

    public int xorAfterQueries(int[] nums, int[][] queries) {
        for(int[] q: queries){
            int idx = q[0];
            int r = q[1];
            int k = q[2];
            int vi = q[3];
            while(idx<=r){
                nums[idx] = (nums[idx] * vi) % (109 + 7);
                idx+=k;
            }
        }
        int xor = 1;
        for(int i=0;i<nums.length;i++){
            xor^=nums[i];
        }
        return xor;
    }
}
