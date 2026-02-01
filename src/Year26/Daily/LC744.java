package Year26.Daily;

import java.util.Arrays;

public class LC744 {

    public static void main(String[] args) {
        char[] t = new char[]{'c','f','g'};
        System.out.println(nextGreatestLetter(t,'c'));
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        for(int i=0;i<letters.length;i++){
            if(target<letters[i]) return letters[i];
        }
        return letters[0];
    }
}
