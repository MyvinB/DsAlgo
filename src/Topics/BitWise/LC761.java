package Topics.BitWise;

import java.util.Collections;
import java.util.*;

public class LC761 {

    public static void main(String[] args) {
        System.out.println(makeLargestSpecial("11100010"));
    }

    public static String makeLargestSpecial(String s) {
        int count = 0;
        int start = 0;
        List<String> specialString = new ArrayList<>();
        for(int i=0;i<s.length();i++){
           count += s.charAt(i)=='1'?1:-1;
           if(count==0){
               String inner = "1" +makeLargestSpecial(s.substring(start+1,i))+ "0";
               specialString.add(inner);
               start = i+1;

           }
        }

        Collections.sort(specialString, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(String str:specialString){
            sb.append(str);
        }
        return sb.toString();
    }
}
