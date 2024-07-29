package Daily;

public class LC1395 {

    public static void main(String[] args) {
        int[] t = new int[]{2,5,3,4,1};
        System.out.println(numTeams(t));
    }

    public static int numTeams(int[] rating) {
        int n = rating.length;
        int sum = 0;
        for(int i=1;i<n-1;i++){
            int leftSmaller = 0,rightLarger = 0;
            for(int j=0;j<i;j++){
                if(rating[j]<rating[i]){
                    leftSmaller++;
                }
            }
            for(int j=i+1;j<n;j++){
                if(rating[j]>rating[i]){
                    rightLarger++;
                }
            }
            int leftLarger = i-leftSmaller;
            int rightSmaller = (n-1)-i-rightLarger;
            sum+= (leftSmaller*rightLarger);
            sum+= (leftLarger*rightSmaller);
        }
        return sum;
    }
}
