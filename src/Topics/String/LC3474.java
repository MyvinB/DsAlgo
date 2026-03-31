package Topics.String;

import java.util.Arrays;

public class LC3474 {

    public static void main(String[] args) {

    }

    public boolean isSame(Character[] word,int start, String str2){
        for(int i=0;i<str2.length();i++){
            if(word[i+start]!= str2.charAt(i)){
                return false;
            }
        }
        return true;
    }

    public String generateString(String str1, String str2) {
         /*Story to code
        Fill T with Str 2 and check if its not already populated with something else with previous fill if it is return false.
        Rename spaces that can change with to True in a boolean array and fill remaining spaces with a
        Check validaity of F and csee if anything can change from right to left.
        * */
        int m = str1.length();
        int n = str2.length();
        Character[] word = new Character[m+n-1];
        boolean[] canChange = new boolean[m+n-1];
        Arrays.fill(word,'$');
        //Step1: Fill T with Str 2 and check if its not already populated with something else with previous fill if it is return false.
        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i)=='T'){
                for(int j=0;j<n;j++){
                    if(word[i+j]!='$' && word[i+j]!=str2.charAt(j)){
                        return "";
                    }
                    word[i+j] = str2.charAt(j);
                }
            }
        }

        // Step 2: Rename spaces that can change with to True in a boolean array and fill remaining spaces with a
        for(int i=0;i<m+n-1;i++){
            if(word[i]=='$'){
                word[i] = 'a';
                canChange[i] = true;
            }

        }
        // Step 3: Check validaity of F and see if anything can change from right to left.
        for(int i=0;i<m;i++){
            if(str1.charAt(i)=='F'){
                if(isSame(word,i,str2)){
                    boolean change = false;
                    for(int k=i+n-1;k>=i;k--){
                        if(canChange[k]){
                            word[k] = 'b';
                            change = true;
                            break;
                        }
                    }
                    if(!change) return "";
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<m+n-1;i++){
            sb.append(word[i]);
        }
        return sb.toString();
    }
}
