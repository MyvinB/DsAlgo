package Topics.BitWise;

import java.util.ArrayList;
import java.util.List;

public class LC1545 {


    public static void main(String[] args) {
        System.out.println(findKthBit(4,11));
    }

    public static char findKthBit(int n, int k) {
        List<String> list = new ArrayList<>();
        list.add("0");
        list.add("011");
        for(int i=2;i<n;i++){
            String s = list.get(i-1) + '1' + invertBitAndReverse(list.get(i-1));
            list.add(s);
        }
        return list.get(n-1).charAt(k-1);
    }

    public static String invertBitAndReverse(String s){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++) {
            if (s.charAt(i) == '1') {
                sb.append('0');
            } else {
                sb.append('1');
            }
        }
        return sb.reverse().toString();
    }
}
