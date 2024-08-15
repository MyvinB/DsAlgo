package Daily;

public class LC860 {

    public static void main(String[] args) {
        int[] t = new int[]{5,5,10,20,5,5,5,5,5,5,5,5,5,10,5,5,20,5,20,5};
        System.out.println(lemonadeChange(t));
    }

    public static boolean lemonadeChange(int[] bills) {
        int[] count = new int[21];
        for(int i=0;i<bills.length;i++){
            if(bills[i]==10 && count[5]>0){
                count[5]--;
            }
            else if(bills[i]==20 && count[5]>0 && count[10]>0){
                count[5]--;
                count[10]--;
            }
            else if(bills[i]==20 && count[5]>=3){
                count[5]-=3;
            }
            else if(bills[i]!=5){
                return false;
            }
            count[bills[i]]++;
        }

        return true;
    }
}
