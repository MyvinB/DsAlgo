package Topics.BitWise;

public class LC762 {

    public static void main(String[] args) {
        System.out.println(countPrimeSetBits(10,15));
    }

    public static int countPrimeSetBits(int left, int right) {
        int count = 0;
        for(int i=left;i<=right;i++){
            int bitCount = getBit(i);
            if(isPrime(bitCount)){
                count++;
            }
        }
        return count;
    }


    private static int getBit(int n){
        int count = 0;
        while(n!=0){
            if((n&1)==1)count++;
            n>>=1;
        }
        return count;
    }

    private static boolean isPrime(int n){
        if(n<=1) return false;

        for(int i=2;i<n;i++){
            if(n%i==0) return false;
        }
        return true;
    }
}
