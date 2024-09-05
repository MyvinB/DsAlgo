package Daily;

import java.util.Arrays;

public class LC2028 {

    public static void main(String[] args) {
        int[] t = new int[]{4,2,2,5,4,5,4,5,3,3,6,1,2,4,2,1,6,5,4,2,3,4,2,3,3,5,4,1,4,4,5,3,6,1,5,2,3,3,6,1,6,4,1,3 };
        System.out.println(Arrays.toString(missingRolls(t,2,53)));
    }


    public static int[] missingRolls(int[] rolls, int mean, int n) {
        int mSum = 0;
        int noOfElem = n;
        for(int i=0;i<rolls.length;i++){
            mSum += rolls[i];
            noOfElem +=1;
        }
        //(mean * num of elements) - sum of m;
        int nSum = (mean*noOfElem) - mSum;

        int ele = nSum/n;
        int rem = nSum%n;
        if(ele>6  || nSum<0 || (ele==6 && rem!=0) || n>nSum ){
            return new int[]{};
        }
        int[] nArr = new int[n];
        for(int i=0;i<n;i++){
            nArr[i] = ele;
        }
        int idx = 0;

        int left = 6- ele;
        while(idx<n){
            if(rem == 0){
                break;
            }
            if(left>rem){
                nArr[idx] +=rem;
                rem = 0;
            } else{
                nArr[idx] += left;
                rem -=left;
            }
            idx++;
        }
        return nArr;
    }

    public static int[] missingRollsOptimised(int[] rolls, int mean, int n) {
        int mSum = 0;
        int noOfElem = n;
        for(int i=0;i<rolls.length;i++){
            mSum += rolls[i];
            noOfElem +=1;
        }
        //(mean * num of elements) - sum of m;
        int nSum = (mean*noOfElem) - mSum;
        if(nSum>n*6 || nSum<n){
            return new int[]{};
        }
        int ele = nSum/n;
        int rem = nSum%n;
        int left = 6 - ele;
        int[] nArr = new int[n];
        Arrays.fill(nArr,ele);
        for(int i=0;i<n;i++){
            if(rem>left){
                nArr[i] +=left;
                rem -= left;
            }
            else{
                nArr[i]+= rem;
                break;
            }
        }
        return nArr;
    }



}
