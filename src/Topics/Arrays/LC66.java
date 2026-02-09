package Topics.Arrays;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC66 {

    public static void main(String[] args) {
        int[] t = new int[]{8,9,9,9};
        System.out.println(Arrays.toString(plusOneOptimised(t)));
        ;
    }

    public static int[] plusOne(int[] digits) {
        List<Integer> list = new ArrayList<>();
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + carry > 9) {
                list.add(0);
            } else {
                list.add(digits[i] + carry);
                carry = 0;
            }
        }
        if (carry == 1) list.add(1);
        int[] ans = new int[list.size()];
        int n = list.size() - 1;
        for (int i = 0; i < list.size(); i++) {
            ans[n - i] = list.get(i);
        }
        return ans;
    }

    public static int[] plusOneOptimised(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]+1<=9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[digits.length+1];
        res[0] = 1;
        return res;
    }


}
