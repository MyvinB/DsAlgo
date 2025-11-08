package Daily;

public class LC1611 {

    public static void main(String[] args) {

    }

    public int minimumOneBitOperations(int n) {
        if(n==0) return 0;

        int k = 0;
        int cur = 1;
        while(cur*2<=n){
            cur *=2;
            k++;
        }
         return (1<<(k+1)) -1 -minimumOneBitOperations(cur^n);
    }
}
