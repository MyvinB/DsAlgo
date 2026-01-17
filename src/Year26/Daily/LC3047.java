package Year26.Daily;

public class LC3047 {

    public static void main(String[] args) {
       // Test 1 res 1
//        int[][] bL = new int[][]{{1,1},{2,2},{3,1}};
//        int[][] tr = new int[][]{{3,3},{4,4},{6,6}};
//        int[][] bL = new int[][]{{1,1},{1,3},{1,5}};
//        int[][] tr = new int[][]{{5,5},{5,7},{5,9}};

        int[][] bL = new int[][]{{1,1},{3,3},{3,1}};
        int[][] tr = new int[][]{{2,2},{4,4},{4,2}};

//        int[][] bL = new int[][]{{1,1},{2,2},{1,2}};
//        int[][] tr = new int[][]{{3,3},{4,4},{3,4}};
        System.out.println(largestSquareArea(bL,tr));
    }

    public static long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long area = 0;
        for(int i=0;i<bottomLeft.length;i++){
            for(int j=i+1;j<bottomLeft.length;j++){
                int top = Math.min(topRight[i][1],topRight[j][1]);
                int bottom = Math.max(bottomLeft[i][1],bottomLeft[j][1]);
                int left = Math.max(bottomLeft[i][0],bottomLeft[j][0]);
                int right = Math.min(topRight[i][0],topRight[j][0]);
                if(left<right && bottom<top){
                    int height = top-bottom;
                    int width = right-left;
                    int side = Math.min(height,width);
                    area = Math.max(area,1L*side*side);
                }
            }
        }
        return area;
    }
}
