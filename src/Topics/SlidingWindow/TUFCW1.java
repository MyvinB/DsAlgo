package Topics.SlidingWindow;

/**
 * Created by myvinbarboza on 24/04/25 at 12:35 PM
 * Today is a Thursday
 * Q Maximum Points You Can Obtain from Cards
 * Given N cards arranged in a row, each card has an associated score denoted by the cardScore array. Choose exactly k cards. In each step, a card can be chosen either from the beginning or the end of the row. The score is the sum of the scores of the chosen cards.
 *
 *
 *
 * Return the maximum score that can be obtained.
 * Input : cardScore = [1, 2, 3, 4, 5, 6] , k = 3
 *
 * Output : 15
 *
 * Explanation : Choosing the rightmost cards will maximize your total score. So optimal cards chosen are the rightmost three cards 4 , 5 , 6.
 *
 * Th score is 4 + 5 + 6 => 15.
 */
public class TUFCW1 {

    public static void main(String[] args) {
        int[] t = new int[]{5, 4, 1, 8, 7, 1, 3};
        int k = 3;
        System.out.println(maxScore(t,3));
    }

    public static int maxScore(int[] cardScore, int k) {
        //your code goes here
        int n = cardScore.length;
        int lSum = 0;
        int rSum = 0;
        int maxScore = 0;
        for(int i=0;i<k;i++){
            lSum+=cardScore[i];
        }
        maxScore = lSum;
        int r=cardScore.length-1;
        for(int i=k-1;i>=0;i--){
            lSum-=cardScore[i];
            rSum+=cardScore[r];
            maxScore = Math.max(lSum+rSum,maxScore);
            r-- ;
        }
        return maxScore;
    }
}
