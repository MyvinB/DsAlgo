package Year26.Daily;

public class LC190 {

    public static void main(String[] args) {
        int n = 43261596;
        int res = 0;
        for(int i=0;i<32;i++){
            res<<=1;
            if(((n&1)==1)) res++;
            n>>=1;
        }
        System.out.println(res);
    }

    public int reverseBits(int n) {
        if(n==0) return 0;
        int res = 0;
        for(int i=0;i<32;i++){
            res<<=1;
            if((n&1)==1) res++;
            n>>=1;
        }
        return res;
    }

}
