package Year26.Contest.WC490;

public class LCQ1 {

    public static void main(String[] args) {
        int[] t = new int[]{2,4,2,1,2,1};
        System.out.println(scoreDifference(t));
    }

    public static int scoreDifference(int[] nums) {
        int scoreA = 0;
        int scoreB = 0;
        int curPlayer = 1; //1 for A 0 for B
        for(int i=0,j=5;i<nums.length;i++){
            //odd check switch
            if(nums[i]%2!=0){
                if(curPlayer==1){
                    curPlayer = 0;
                } else {
                    curPlayer = 1;
                }
            }
            //index check switch
            if(i!=0 && i==j){
                if(curPlayer==1){
                    curPlayer = 0;
                } else {
                    curPlayer = 1;
                }
                j=j+6;
            }

            if(curPlayer==1){
                scoreA+=nums[i];
            } else{
                scoreB+=nums[i];
            }
        }
        return scoreA-scoreB;
    }
}
