package Daily;

public class LC1518 {


    public static void main(String[] args) {
        System.out.println(numWaterBottles(15,4));
    }


    public static int numWaterBottles(int numBottles, int numExchange) {
        int totalDrank = numBottles;
        while(numBottles/numExchange!=0){
            int q = numBottles/numExchange;
            int r = numBottles%numExchange;
            totalDrank += q;
            numBottles = q+r;
        }
        return totalDrank;
    }
}
