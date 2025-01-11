package Daily;

import java.nio.charset.StandardCharsets;

public class LC3042 {

    public static void main(String[] args) {
        System.out.println(isPrefixAndSuffix("b","ab"));
    }

    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isPrefixAndSuffix(words[i],words[j])) count++;
            }
        }
        return count;
    }

    public static boolean isPrefixAndSuffix(String str1, String str2){
        int i=0;
        int j=0;
        while(i<str1.length() && j<str2.length() && str1.charAt(i)==str2.charAt(j)){
            i++; j++;
        }
        if(i!=str1.length()) return false;
        i=str1.length()-1;
        j=str2.length()-1;
        while(j>=0 && i>=0 && str1.charAt(i)==str2.charAt(j)){
            j--;i--;
        }
        if(i!=-1) return false;
        return true;
    }

}
