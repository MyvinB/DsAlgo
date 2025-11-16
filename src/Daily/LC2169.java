package Daily;

public class LC2169 {



    public int countOperationsOld(int num1, int num2) {
        int count = 0;
        while(num1>0 && num2>0){
            if(num1>=num2){
                num1 = num1-num2;
            }else if(num1<num2){
                num2 = num2-num1;
            }
            count++;
        }
        return count;
    }

    public int countOperations(int num1, int num2) {
        int c = 0;
        int temp = -1;
        while(num1!=0 && num2!=0){
            c+= num1/num2;
            num1 = num1%num2;
            temp = num1;
            num1 = num2;
            num2 = num1;
        }
        return c;
    }



}
