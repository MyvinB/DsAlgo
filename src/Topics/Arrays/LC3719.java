package Topics.Arrays;

import java.util.HashSet;

public class LC3719 {


    public static void main(String[] args) {
        int[] t = new int[]{2,5,4,3};
        System.out.println(longestBalanced(t));
    }

    public static  int longestBalanced(int[] nums) {
        int evenCount = 0;
        int oddCount = 0;
        HashSet<Integer> set = new HashSet<>();
        int size = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(!set.contains(nums[j])){
                    if(nums[j]%2==0){
                        evenCount++;
                    } else{
                        oddCount++;
                    }
                    set.add(nums[j]);
                }
                if(evenCount!=0 && evenCount==oddCount){
                    size = Math.max(size,j-i+1);
                }
            }
            set = new HashSet<>();
            evenCount = 0;
            oddCount = 0;
        }
        return size;
    }
}
