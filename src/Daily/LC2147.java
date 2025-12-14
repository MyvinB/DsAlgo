package Daily;

import java.util.ArrayList;
import java.util.List;

public class LC2147 {

    public static void main(String[] args) {
        System.out.println(numberOfWays("SPSPPSSPSSSS"));
//        0 2 5 6 8 9 10 11
//        S P S  P P S S  P S S  S  S
//        0 1 2  3 4 5 6  7 8 9  10 11
    }

    public static int numberOfWays(String corridor) {
        final int MOD = 1_000_000_007;
        int sCount = 0;
        for(int i=0;i<corridor.length();i++){
            if(corridor.charAt(i)=='S') sCount++;
        }
        if(sCount%2!=0 || sCount==0) return 0;
        int count = 0;
        int flag = 0;
        long ans = 1;
        int pCount = 0;
        for(int i=0;i<corridor.length();i++){
            if(corridor.charAt(i)=='S'){
                count++;
                if(count==2){
                    flag = 1;
                }else if(count>2){
                    count = 1;
                    flag = 0;
                    ans = (ans*(pCount+1))%MOD;
                    pCount = 0;
                }
            } else if(flag==1){
                pCount++;
            }
        }
        return (int)ans;
    }
}
