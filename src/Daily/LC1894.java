package Daily;

public class LC1894 {


    public static void main(String[] args) {
        int k=22;
        int[] chalk = new int[]{5,1,5};
        chalkReplacer(chalk,k);
    }

    public static int chalkReplacer(int[] chalk, int k) {
        long sum =0;
        int n = chalk.length;
        for(int i=0;i<n;i++){
            sum+=chalk[i];
            if(sum>k){
                return i;
            }
        }
        k = k%(int)sum;
        for(int i=0;i<n;i++){
            if(chalk[i]>k){
                return i;
            }
            k = k- chalk[i];
        }
        return 0;
    }
}
