package Daily;

public class LC2429 {

    public static void main(String[] args) {
        System.out.println(minimizeXor(1,21));
    }



    public static int minimizeXor(int num1, int num2) {
        //Count number of bits in num2
        int count = 0;
        while(num2!=0){
            num2 = num2 & (num2-1);
            count++;
        }
        int res = 0;
        //Get the left most bit in num1 so 1 xor 1 would be zero to get the number minimum
        for(int i=31;i>=0;i--){
            if((num1 & (1<<i))!=0){
                count--;
                res+=1<<i;
            }
        }
        //Start place the remaining count from the right as its minimum value
        for(int i=0;i<=31 && count!=0;i++){
            if((num1&(1<<i))==0){
                count--;
                res+=1<<i;
            }
        }
        return res;
    }
}
