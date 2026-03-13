package Year26.Contest.WC492;

public class LCQ2 {

    public static void main(String[] args) {
        int[] t = new int[]{1,3};
        System.out.println(smallestBalancedIndex(t));
    }


    public static int smallestBalancedIndex(int[] nums) {
        int n = nums.length;
        if(n==2){
            if(nums[0] == 1) return 1;
        }
        int[] leftSum = new int[n];
        int[] rightProduct = new int[n];
        int lSum = 0;
        int rProduct = 1;
        for(int i=0;i<n;i++){
            lSum+=nums[i];
            leftSum[i] = lSum;
        }
        for(int i=n-1;i>=0;i--){
            rProduct *=nums[i];
            rightProduct[i] = rProduct;
        }
        for(int i=0;i<n;i++){
            if(i>0 && i+1<n && leftSum[i-1]==rightProduct[i+1]){
                return i;
            }
        }
        return -1;
    }
}
