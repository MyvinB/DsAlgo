package Daily;

import jdk.jshell.spi.SPIResolutionException;

import java.util.ArrayList;
import java.util.List;

public class LC2145 {

    public static void main(String[] args) {
        int[] t = new int[]{3,-4,5,1,-2};
        System.out.println(numberOfArrays(t,-4,5));
    }

    public static int numberOfArrays(int[] differences, int lower, int upper) {
        List<Integer> list = new ArrayList<>();
        int preRun = 0;
        for(int i=0;i<differences.length;i++){
            preRun += differences[i];
            list.add(preRun);
        }
        int value = 0;
        int count = 0;
        int check = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<list.size();i++) {
            min = Math.min(min,list.get(i));
            max = Math.max(max,list.get(i));
        }

        for(int i=lower;i<=upper;i++){
            check = 1;
            value = min+i;
            if(value<lower || value>upper) check = -1;
            value = max+i;
            if(value<lower || value>upper) check = -1;
            if(check==1) count++;
        }
        return count;

    }

    //Using Sliding Window and one Run
    public static int numberOfArraysOptuimised(int[] differences, int lower, int upper) {
        int preRun = 0;
        int min = 0;
        int max = 0;
        for(int i=0;i<differences.length;i++){
            preRun += differences[i];
            min = Math.min(min,preRun);
            max = Math.max(max,preRun);
            if (max - min > upper - lower) {
                return 0;
            }
        }
        // (upper-max) - (lower-min) +1 is the actual value but we rearrage to make it easier
        return (upper-lower)- (max-min) +1;

    }
}
