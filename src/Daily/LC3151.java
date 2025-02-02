package Daily;

public class LC3151 {


    public static void main(String[] args) {
        int[] t = new int[]{2,1,4};
        System.out.println(isArraySpecial(t));
    }

    public static boolean isArraySpecial(int[] nums) {
        int n = nums.length;
        if(nums.length==1) return true;
        for(int i=1;i<n;i++){
            boolean before = nums[i-1]%2==0;
            boolean idx = nums[i]%2==0;
            if(before==idx){
                return false;
            }
        }
        return true;
    }
}
