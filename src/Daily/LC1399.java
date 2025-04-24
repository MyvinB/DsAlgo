package Daily;



/**
 * Created by myvinbarboza on 23/04/25 at 7:41 AM
 * Today is a Wednesday
 */
public class LC1399 {

    public static void main(String[] args) {
        System.out.println(countLargestGroup(13));
    }

    public static int countLargestGroup(int n) {
        int[] count = new int[37];
        int size = 0;
        for(int i=1;i<=n;i++){
            int sum = 0;
            int a = i;
            while(a!=0){
                sum+=a%10;
                a=a/10;
            }
            count[sum]++;
            size = Math.max(size,count[sum]);
        }
        int total=0;
        for(int i=1;i<37;i++){
            if(count[i]==size){
                total+=1;
            }
        }
        return total;
    }


}
