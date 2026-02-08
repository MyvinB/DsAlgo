package Year26.Contest.WC488;

public class LC1 {

    public static void main(String[] args) {
        int[] t = new int[]{4,1,2};
        System.out.println(dominantIndices(t));
    }

    public static int dominantIndices(int[] nums) {
        int sum = 0;
        int n = nums.length;
        int count = 0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        int number = n-1;
        for(int i=0;i<n-1;i++){
            if((nums[i]*number)>sum-nums[i]){
                count++;
            }
            sum-=nums[i];
            number--;
        }
        return count;
    }
}
