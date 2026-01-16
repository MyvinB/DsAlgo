package Year26.Daily;

import java.util.Arrays;

public class LC2943 {


    public static void main(String[] args) {
        int[] t = new int[]{2,3};
        int[] q = new int[]{1};
        maximizeSquareHoleArea(1,1,t,q);
    }

    public static int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int cn1=1,max1=0,cn2=1,max2 = 0;
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int i = 1,j=1;
        while(i< hBars.length){
            if(hBars[i]-hBars[i-1]==1){
                cn1++;
            }else {
                cn1 = 1;

            }
            i++;
            max1 = Math.max(max1,cn1);
        }
        while(j<vBars.length){
            if(vBars[j]-vBars[j-1]==1){
                cn2++;
            }else{
                cn2=1;
            }
            j++;
            max2 = Math.max(max2,cn2);
        }
        max1 = Math.max(max1,cn1);
        max2 = Math.max(max2,cn2);
        int min = Math.min(max1,max2);
        return (min+1)*(min+1);
    }
}
