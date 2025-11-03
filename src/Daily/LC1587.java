package Daily;

public class LC1587 {

    public static void main(String[] args) {
        System.out.println(minCost("abaac", new int[]{1,2,3,4,5}));
//        System.out.println(minCost("bbbaaa", new int[]{4,9,3,8,8,9}));

    }

    public static int minCost(String colors, int[] neededTime) {
        int ans = 0;
        int i = 0;
        int n= colors.length();
        int max=0;
        int sum = 0;
        while(i<n){
            max = 0;
            while(i+1<n && colors.charAt(i)==colors.charAt(i+1)){
                sum += neededTime[i];
                max = Math.max(max,neededTime[i]);
                i++;
            }
            sum+=neededTime[i];
            max=Math.max(max,neededTime[i]);
            sum-=max;
            i++;
        }
        return sum;
    }
}
