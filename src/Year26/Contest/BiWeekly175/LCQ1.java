package Year26.Contest.BiWeekly175;

import java.util.ArrayList;
import java.util.List;

public class LCQ1 {

    public static void main(String[] args) {
        System.out.println(reverseByType("!@#$%^&*()"));
    }

    public static String reverseByType(String s) {
        if(s.length()==1) return s;
        List<Character> letter = new ArrayList<>();
        List<Character> special = new ArrayList<>();
        char[] temp = new char[s.length()];
        for(int i=0;i<s.length();i++){
            char cur = s.charAt(i);
            if(cur>='a' && s.charAt(i)<='z'){
                letter.add(cur);
            }
            else{
                special.add(cur);
            }
        }
        int k = letter.size()-1;
        for(int i=0;i<s.length();i++){
            char cur = s.charAt(i);
            if(cur>='a' && s.charAt(i)<='z' && k>=0) {
                temp[i] = letter.get(k--);
            }else{
                temp[i] = cur;
            }
        }
        k = special.size()-1;
        for(int i=0;i<s.length();i++){
            char cur = temp[i];
            if(!Character.isLetterOrDigit(cur) && k>=0) {
                temp[i] = special.get(k--);
            }else{
                temp[i] = cur;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int p=0;p<temp.length;p++){
            sb.append(temp[p]);
        }
        return sb.toString();

    }

}
