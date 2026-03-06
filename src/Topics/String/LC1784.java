package Topics.String;

public class LC1784 {

    public static void main(String[] args) {

    }

    public boolean checkOnesSegment(String s) {
        for(int i=0;i+1<s.length();i++){
            if(s.charAt(i)=='0' && s.charAt(i+1)=='1'){
                return false;
            }
        }
        return true;
    }
}
