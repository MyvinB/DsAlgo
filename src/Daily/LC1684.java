package Daily;

public class LC1684 {


    public static void main(String[] args) {

    }

    public int countConsistentStrings(String allowed, String[] words) {
        int[] t = new int[26];
        for(int i=0;i<allowed.length();i++){
            t[allowed.charAt(i)-'a']++;
        }
        int count = 0;
        for(String w:words){
            boolean check = true;
            for(char ch:w.toCharArray()){
                if(t[ch-'a']==0){
                    check = false;
                    break;
                }
            }
            if(check) count++;
        }
        return count;
    }
}
