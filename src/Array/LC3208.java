package Array;

public class LC3208 {

    public static void main(String[] args) {
        int[] colors = new int[]{0,1,0,0,1,0,1};
        System.out.println(numberOfAlternatingGroups(colors,6));
    }

    public static int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length,maxLen=1,ans=0;
        //it is k-1 including the last elemnt so -1
        for(int i=1;i<n+k-1;i++){
            if(colors[i%n]!=colors[(i-1+n)%n]){
                maxLen++;
            }else {
                maxLen = 1;
            }
            if(maxLen>=k) {
                ans++;
            }
        }
        return ans;
    }
}
