package Daily;

public class LC2220 {


    public static void main(String[] args) {

    }

    public int minBitFlips(int start, int goal) {
        //using xor to find the bits thats are uncommon
        int xor = start ^ goal;
        int ans = 0;
        while(xor!=0){
            ans+= xor & 1;
            xor = xor>>1;
        }
        return ans;
    }
}
