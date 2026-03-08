package Year26.Contest.WC492;

public class LCQ1 {

    public static void main(String[] args) {
        int[] t = new int[]{1,5,3,7};
        System.out.println(minimumIndex(t,3));
    }


    public static int minimumIndex(int[] capacity, int itemSize) {
        int minVal = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i=0;i<capacity.length;i++){
            if(capacity[i]>=itemSize && capacity[i]<minVal){
                minIndex = i;
                minVal = capacity[i];
            }
        }
        return minIndex;
    }
}
