package Topics.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by myvinbarboza on 08/09/25 at 1:01 PM
 * Today is a Monday
 */
public class LC15 {

    public static void main(String[] args) {
        int[] t = new int[]{-1,0,1,2,-1,-4};
        int[] t1 = new int[]{2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10};
        System.out.println(threeSum(t));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int l=i+1;
            int h=n-1;
            while(l<h){
                int sum = nums[i]+nums[l]+nums[h];
                if(sum==0){
                    temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[l]);
                    temp.add(nums[h]);
                    list.add(temp);
                    l++;
                    h--;
                    while(l<h && nums[l]==nums[l-1]) l++;
                    while(l<h && nums[h]==nums[h+1]) h--;
                }
                else if(sum>0){
                    h--;
                }
                else if(sum<0){
                    l++;
                }

            }
        }
        return list;

    }
}
