package Year26.Contest.WC493;

public class LCQ2 {

    public static void main(String[] args) {
        System.out.println(countCommas(12345678));
    }

    public static long countCommas(long n) {
        long start = 1000;
        long comma = 1;
        long count = 0;
        while(start<=n){
            long end = start*1000-1;
            count += (Math.min(end,n)-start+1)* comma;
            start *= 1000;
            comma++;
        }
        return count;
    }
}
