package Year26.Contest.WC490;

import java.util.*;

public class LCQ3 {

    public static void main(String[] args) {
        System.out.println(maximumXor("0101","1001"));

    }

    public static String maximumXor(String s, String t){
        int zeroCount = 0;
        int oneCount = 0;
        for(int i=0;i<t.length();i++){
            if(t.charAt(i)=='0') zeroCount++;
            else oneCount++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0' && oneCount>0){
                --oneCount;
                sb.append("1");
            } else if(s.charAt(i)=='1' && zeroCount>0){
                --zeroCount;
                sb.append("1");
            } else if(oneCount>0){
                --oneCount;
                sb.append("0");
            } else if(zeroCount>0){
                --zeroCount;
                sb.append("0");
            }
        }
        return sb.toString();
    }
}
