package Year26.Contest.C486;

public class LC486Q1 {


    public static void main(String[] args) {
        int[] t = new int[]{-1,-1,2,3,3,4,5};
        int[] t1 = new int[]{4,3,-2,-5};
        int[] t2 = new int[]{1,2,3,4};
        System.out.println(minimumPrefixLength(t2));
    }

    public static int minimumPrefixLength(int[] nums) {
        int count = 0;
        int n = nums.length;
        for(int i=1;i<n;i++){
            if(nums[i]>nums[i-1]){
                count++;
            }else{
                count = 0;
            }
        }

        return n-count-1;
    }
}
