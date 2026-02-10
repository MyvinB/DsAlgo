package Topics.SlidingWindow;

public class LC3 {

    public static void main(String[] args) {
        String t = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(t));
    }

    public static int lengthOfLongestSubstring(String s) {
        int[] t = new int[256];
        int n = s.length();
        int j = 0;
        int size = 0;
        for(int i=0;i<n;i++){
            t[s.charAt(i)]++;
            //decrease window size
            while(t[s.charAt(i)]>1){
                t[s.charAt(j)]--;
                j++;
            }
            size = Math.max(size,i-j+1);
        }
        return size;
    }
}
