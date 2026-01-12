package Year26.Daily;

public class LC1266 {


    public static void main(String[] args) {
        int[][] t = new int[][]{{3,2},{-2,2}};
        System.out.println(minTimeToVisitAllPoints(t));
    }

    public static int minTimeToVisitAllPoints(int[][] points) {
        int[] prev = points[0];
        int n = points.length;
        int sum = 0;
        for(int i=1;i<n;i++){
            int cur[] = points[i];
            int x = Math.abs(cur[0] - prev[0]);
            int y = Math.abs(cur[1] - prev[1]);
            if(x<y){
                sum += y;
            } else sum+=x;
            prev = cur;
        }
        return sum;

    }
}
