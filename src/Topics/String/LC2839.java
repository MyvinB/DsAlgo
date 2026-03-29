package Topics.String;

public class LC2839 {

    public static void main(String[] args) {
        System.out.println(canBeEqual("abcd","cdab"));
    }

    public static boolean canBeEqual(String s1, String s2) {
        char[] s2Arr = s2.toCharArray();
        for(int i=0;i<4;i++){
            if(s1.charAt(i)!=s2Arr[i]){
                if(i+2>=4) return false;
                if(s1.charAt(i)!=s2Arr[i+2]) return false;
                else{
                    char temp = s2Arr[i+2];
                    s2Arr[i+2] = s2Arr[i];
                    s2Arr[i] = temp;
                }
            }
        }
        return true;
    }
}
