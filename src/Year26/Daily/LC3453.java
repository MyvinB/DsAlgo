package Year26.Daily;

public class LC3453 {

    public static void main(String[] args) {
        int[][] t = new int[][]{{0,0,2},{1,1,1}};
    }

    public double separateSquares(int[][] squares) {
        double totalArea = 0;
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        for(int[] sq:squares){
            double x = sq[0];
            double y = sq[1];
            double len = sq[2];
            totalArea +=(len*len);
            min = Math.min(y,min);
            max = Math.max(y+len,max);
        }
        //Binary search
        double low = min, high = max;

        for(int i=0;i< 100;i++){
            double mid = (high+low) / 2;
            if(calculateArea(mid,squares)<totalArea/2){
                low = mid;
            } else high = mid;
        }
        return high;
    }

    public double calculateArea(double mid,int[][] squares){
        double area = 0;
        for(int[] sq:squares){
            double y = sq[1];
            double len = sq[2];
            if(mid>=y+len){
                area+=(len*len);
            }else if(mid>y && mid<y+len){
                area+= (len*(mid-y));
            }
        }
        return area;
    }
}
