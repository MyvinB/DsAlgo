package Daily;

import java.util.ArrayList;
import java.util.List;

public class LC916 {


    public static void main(String[] args) {
        String[] words1 = new String[]{"google","leetcode"};
        String[] words2 = new String[]{"lo","eo"};
        String[] words3 = new String[]{"amazon","apple","facebook","google","leetcode"};
        String[] words4 = new String[]{"e","o"};
        System.out.println(wordSubsets(words3,words4));
    }



    private static int[] count(String p){
        int[] q = new int[26];
        for(char ch:p.toCharArray()){
            q[ch-'a']++;
        }
        return q;
    }


    public static List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> res = new ArrayList<>();
        int[] maxCount = new int[26];
        //Getting maxCount for a character
        for(int i=0;i< words2.length;i++){
            int[] w1Count = count(words2[i]);
            for(int j=0;j<26;j++){
                maxCount[j] = Math.max(maxCount[j],w1Count[j]);
            }
        }
        for(int i=0;i<words1.length;i++){
            int[] w2Count = count(words1[i]);
            boolean check = true;
            for(int j=0;j<26;j++){
                if(maxCount[j]>w2Count[j]){
                    check = false;
                }
            }
            if(check) res.add(words1[i]);
        }
        return res;
    }
}
