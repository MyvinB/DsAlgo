package Daily;

import java.util.Arrays;

public class LC719 {

    public static void main(String[] args) {

    }


    public int smallestDistancePairDistanceBucket(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max,nums[i]);
        }
        int n = nums.length;
        int[] distanceBucket = new int[max+1];
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int d = Math.abs(nums[i]-nums[j]);
                ++distanceBucket[d];
            }
        }

        for(int i=0;i<=max;i++){
            k-=distanceBucket[i];
            if(k<=0){
                return i;
            }
        }
        return -1;
    }

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0;
        int h = nums[n-1]-nums[0];
        while(l<h){
            int mid = (l+h)/2;
            int count = countPairsWithMaxDistance(nums,mid);
            if(count<k){
                l = mid+1;
            }else{
                h = mid;
            }
        }
        return l;
    }

    private int countPairsWithMaxDistance(int[] nums, int maxDistance){
        int count = 0;
        int n = nums.length;
        int left = 0;
        for(int right = 0;right<n;right++){
            while(nums[right]-nums[left]>maxDistance){
                left++;
            }
            count +=right-left;
        }
        return count;
    }
}
