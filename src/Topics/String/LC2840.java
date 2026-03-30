package Topics.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC2840 {

    public static void main(String[] args) {
        String s1 = "abcdba";
        String s2 = "cabdab";
        System.out.println(checkStrings(s1,s2));
    }

    public static boolean checkStrings(String s1, String s2) {
       int[] even = new int[26];
       int[] odd =new int[26];
       int n = s1.length();
       for (int i=0;i<n;i++){
           if(i%2==0){
               even[s1.charAt(i)-'a']++;
               even[s2.charAt(i)-'a']--;
           }else{
               odd[s1.charAt(i)-'a']++;
               odd[s2.charAt(i)-'a']--;
           }
       }
       for(int i=0;i<26;i++){
           if(odd[i]!=0 || even[i]!=0) return false;
       }
       return true;
    }
}
