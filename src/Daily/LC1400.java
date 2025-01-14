package Daily;

public class LC1400 {

    public static void main(String[] args) {

    }

    public boolean canConstruct(String s, int k) {
        if(k==s.length()) return true;
        if(k>s.length()) return false;
        int[] count = new int[26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
        }
        int noOfOdd = 0;
        for(int i=0;i<26;i++){
            if(count[i]%2!=0) noOfOdd++;
        }
        if(noOfOdd>k) return false;
        return true;
    }


}
