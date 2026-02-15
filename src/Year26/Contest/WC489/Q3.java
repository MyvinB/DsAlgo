package Year26.Contest.WC489;

public class Q3 {

    public static void main(String[] args) {
        System.out.println(almostPalindromic("aabca"));
    }

    public static int almostPalindromic(String s) {
        recurMemo(s,0,s.length()-1,0);
        if(count<s.length() && forgive==1){
            return count+1;
        }
        return count;
    }

    static int count = 0;
    static int forgive = 1;
    public static boolean recurMemo(String s, int i, int j,int isPrev){
        if(i>j || j<i) return true;
        boolean choosePalindrome = false;
        boolean doNotChoose = false;
        boolean forgiveChoose = false;
        if(s.charAt(i)==s.charAt(j)){
            choosePalindrome  = recurMemo(s,i+1,j-1,1);
            if(choosePalindrome){
                count = Math.max(count,j-i+1);
            }
        }
        if(isPrev!=1){
            boolean left = recurMemo(s,i+1,j,isPrev);
            boolean right = recurMemo(s,i,j-1,isPrev);
            doNotChoose =  left||right;
        }
        if(forgive==1){
            forgive = 0;
            count = Math.max(count,j-i+1);
            forgiveChoose = recurMemo(s,i+1,j,1) || recurMemo(s,i,j-1,1);
            forgive = 1;
        }

        return choosePalindrome|| doNotChoose || forgiveChoose;
    }
}
