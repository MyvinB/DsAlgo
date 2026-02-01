package Year26.Contest.WeeklyLC487;

public class LCQ1 {

    public static void main(String[] args) {
        System.out.println(countMonobit(1));
    }

    public static int countMonobit(int n) {
        int t = n;
        int count = 0;
        for(int i=t;i>=0;i--){
            int oneC = 0;
            int zeroC = 0;
            int temp = i;
            while(temp>0){
                int bit = temp&1;
                if(bit==0){
                    zeroC++;
                }else{
                    oneC++;
                }
                temp = temp>>1;
            }
            if(oneC==0 && zeroC>=0 || zeroC==0 && oneC>=0) count++;
        }
        return count;
    }
}
