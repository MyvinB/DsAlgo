package Topics.DP;

import java.util.Arrays;
import java.util.HashMap;

public class LC788 {

    public static void main(String[] args) {
        System.out.println(rotatedDigits(2));
    }
    /*
    0 rotates to 0
1 rotates to 1
8 rotates to 8

2 rotates to 5
5 rotates to 2
6 rotates to 9
9 rotates to 6
     */


    public static boolean isGood(int n){
        boolean check = false;
        while(n!=0){
            int d = n%10;
            if(d==3||d==4||d==7) return false;
            if(d==2||d==5||d==6||d==9){
                check = true;
            }
            n = n/10;
        }
        return check;
    }

    public static int rotatedDigits(int n) {
        int count=0;
        for(int i=1;i<=n;i++){
            if(isGood(i)){
                count++;
            }
        }
        return count;
    }

    public static int rotatedDigitsOpti(int n) {
        int count=0;
        int[] t = new int[n+1];
        Arrays.fill(t,-1);
        for(int i=1;i<=n;i++){
            if(solve(i,t)==1){
                count++;
            }
        }
        return count;
    }





    public static int solve(int n,int[] t){
        if(t[n]!=-1){
            return t[n];
        }
        if(n==0){
            return t[n]=0;
        }

        int rem = solve(n/10,t);
        if(rem==2) return t[n]=2;
        int d = n%10;
        int digitChange = 0;
        if(d==0||d==1||d==8) digitChange = 0;
        else if(d==2||d==5||d==6||d==9) digitChange = 1;
        else return t[n]=2;
        if(rem==0 && digitChange==0){
            return t[n]=0;
        }
        return t[n]=1;
    }

    public int rotatedDigitsBottomUpDp(int n) {
        int count = 0;
        int[] t = new int[n+1];
        for(int i=1;i<=n;i++){
            int rem = t[i/10];
            if(rem==2){
                t[i]=2;
                continue;
            }
            int digitChange = 0;
            int d = i%10;
            if(d==0||d==1||d==8) digitChange = 0;
            else if(d==2||d==5||d==6||d==9) digitChange = 1;
            else{
                t[i]=2;
                continue;
            }
            if(rem==0 && digitChange==0){
                t[i]=0;
            }else{
                t[i]=1;
            }
            if(t[i]==1) count++;
        }
        return count;
    }

}
