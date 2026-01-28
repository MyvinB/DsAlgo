package Daily;

public class LC2968 {

    public static void main(String[] args) {
        System.out.println(punishmentNumber(37));
//        System.out.println(getSum(361,19));
    }

    public static int punishmentNumber(int n) {
        int[] t = new int[n+1];
        int preSum = 0;
        for(int i=1;i<=n;i++){
            int val = i*i;
            if(canParition(val,i)){
                System.out.println(i);
                t[i] = val;
                preSum+=val;
            }
        }
        return preSum;
    }

    private static boolean canParition(int val, int target){
        if(target<0 ||val<target){
            return false;
        }
        if(val==target){
            return true;
        }

        return canParition(val / 10, target - val % 10) ||
                canParition(val / 100, target - val % 100) ||
                canParition(val / 1000, target - val % 1000);
    }
}
