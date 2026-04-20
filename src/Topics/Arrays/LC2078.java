package Topics.Arrays;

public class LC2078 {

    public static void main(String[] args) {
        int[] t = new int[]{1,1,1,6,1,1,1};
        int[] p = new int[]{6,6,6,6,6,6,6,6,6,19,19,6,6};
        System.out.println(maxDistance(p));
    }

    public static int maxDistance(int[] colors) {
        int l = 0;
        int r = colors.length-1;
        int max = 0;
        while(l<r){
            if(colors[l]==colors[r]){
                l++;
            }else if(colors[l]!=colors[r]){
                max = r-l;
                break;
            }
        }
        l = 0;
        r = colors.length-1;
        while(l<r){
            if(colors[l]==colors[r]){
                r--;
            }else if(colors[l]!=colors[r]){
                max = Math.max(r-l,max);
                break;
            }
        }
        return max;
    }
}
