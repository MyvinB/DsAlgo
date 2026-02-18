package Topics.BitWise;

public class LC693 {

    public static void main(String[] args) {
        System.out.println(hasAlternatingBits(7));
    }

    public static boolean hasAlternatingBits(int n) {
        int  prevBit = (n&1)==1?0:1;
        int bit = 0;
        while(n!=0){
            if((n&1)==1){
                bit = 1;
            } else bit =0;
            if(prevBit==bit){
                return false;
            }
            prevBit = bit;
            n>>=1;
        }
        return true;
    }

    public boolean hasAlternatingBitsOpti(int n) {
        int x = n ^ (n>>1);
        return (x & (x+1)) == 0;
    }
}
