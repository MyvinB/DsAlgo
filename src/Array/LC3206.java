package Array;

public class LC3206 {

    public static void main(String[] args) {
        int[] t = new int[]{0,1,0,0,1};
        System.out.println(numberOfAlternatingGroups(t));
    }

    public static int numberOfAlternatingGroups(int[] colors) {
        int n = colors.length;
        int count =0;
        for(int i=0;i<n;i++){
            if(colors[i] != colors[(i+n-1)%n] && colors[i]!=colors[(i+1)%n]){
                count++;
            }
        }
        return count;
    }
}
