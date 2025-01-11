package Daily;

public class LC2158 {


    public static void main(String[] args) {

    }

    public int prefixCount(String[] words, String pref) {
        int n = words.length;
        int t = pref.length();
        int count = 0;
        for(int i=0;i<n;i++){
            if( words[i].length()<=t && words[i].substring(0,t).equals(pref)){
                count++;
            }
        }
        return count;
    }
}
