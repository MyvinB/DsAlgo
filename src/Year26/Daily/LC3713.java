package Year26.Daily;

import java.util.HashSet;

public class LC3713 {

    public static void main(String[] args) {
        System.out.println(longestBalanced("zzabccy"));
    }

    public static int longestBalanced(String s) {
        int n = s.length();
        int prev = -1;
        HashSet<Integer> set = new HashSet<>();
        boolean isBalanced = true;
        int max = -1;
        int[] arr = new int[26];
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                arr[s.charAt(j)-'a']++;
                for(int k=0;k<26;k++){
                    if(arr[k]!=0 && prev==-1){
                        prev = arr[k];
                    } else if(arr[k]!=0 && prev!=arr[k]){
                        isBalanced = false;
                        break;
                    }
                }
                if(isBalanced){
                    max = Math.max(max,j-i+1);
                }
                isBalanced = true;
                prev = -1;
            }
            set = new HashSet<>();
            arr = new int[26];
        }
        return max;
    }
}
