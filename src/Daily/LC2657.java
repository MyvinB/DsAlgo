package Daily;

import java.util.HashMap;

public class LC2657 {

    public static void main(String[] args) {
        int[] A = new int[]{9,3,2,10,8,6,5,7,1,4};
        int[] B = new int[]{7,2,8,1,4,10,5,9,6,3};
        findThePrefixCommonArray(A,B);
    }


    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] count = new int[n+1];
        int[] res = new int[n];
        int sum = 0;
        for(int i=0;i<n;i++){
            count[A[i]]++;
            if(count[A[i]]==2){
                sum+=1;
            }
            count[B[i]]++;
            if(count[B[i]]==2){
                sum+=1;
            }
            res[i] = sum;
        }
        return res;
    }
}
