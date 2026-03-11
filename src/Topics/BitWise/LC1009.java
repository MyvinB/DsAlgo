package Topics.BitWise;

public class LC1009 {


    public static void main(String[] args) {

    }

    public int bitwiseComplement(int n) {
        int i = 0;
        int res = 0;
        do{
            if((n&1)==0){
                res+=1<<i;
            }
            i++;
            n>>=1;
        }while(n!=0);
        return res;
    }
}
