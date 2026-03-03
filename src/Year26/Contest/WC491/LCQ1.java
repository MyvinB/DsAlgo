package Year26.Contest.WC491;

public class LCQ1 {

    public static void main(String[] args) {
        System.out.println(trimTrailingVowels("aeiou"));
    }

    public static String trimTrailingVowels(String s) {
        int i = s.length()-1;
        while(i>=0 && (s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o'|| s.charAt(i)=='u')){
            i--;
        }
        return s.substring(0,i+1);
    }
}
