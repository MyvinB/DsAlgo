package Daily;

import java.util.Arrays;

public class LC1718 {

    public static void main(String[] args) {
        constructDistancedSequence(5);
    }



    public static int[] constructDistancedSequence(int n) {
        int[] nums = new int[2*n-1];
        int[] visited = new int[n+1];
        generateSeq(nums,visited,n,0);
        System.out.println(Arrays.toString(nums));
        return nums;
    }


    public static boolean generateSeq(int[] nums,int[] visited, int n,int idx){
        if(idx==nums.length) return true;

        if(nums[idx]!=0){
            return generateSeq(nums,visited,n,idx+1);
        }

        for(int i=n;i>=1;i--){
            int newIdx = i==1?idx:idx+i;

            if(visited[i]==1 || i>1 && (newIdx>=nums.length || nums[newIdx]!=0)) {
                continue;
            }

            nums[idx] = nums[newIdx] = i;
            visited[i] = 1;
            if(generateSeq(nums,visited,n,idx+1)){
                return true;
            }
            nums[idx] = nums[newIdx] = 0;
            visited[i] = 0;

        }
        return false;
    }
}
