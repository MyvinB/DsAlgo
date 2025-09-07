package Topics.Arrays;

/**
 * Created by myvinbarboza on 07/09/25 at 7:59 PM
 * Today is a Sunday
 */
public class LC11 {

    public static void main(String[] args) {
        int[] t = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxAreaOptimised(t));
     }

    //Naive Approach
    public static int maxArea(int[] height) {
        int n = height.length;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                max = Math.max(max,Math.min(height[i],height[j])*(j-i));
            }
        }
        return max;
    }

    //Height
    public static int maxAreaOptimised(int[] height) {
        int h = height.length-1, l=0;
        int max = Integer.MIN_VALUE;
        //Looks like the aim is to keep the higher one if the lower one is there we increment.
        while(l<h){
            max = Math.max(max, (h-l)*Math.min(height[l],height[h]));
            if(height[l]<height[h]){
                l++;
            }else{
                h--;
            }
        }
        return max;
    }

}
