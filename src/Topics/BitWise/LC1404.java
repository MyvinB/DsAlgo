package Topics.BitWise;

public class LC1404 {

    public static void main(String[] args) {
        System.out.println(numSteps("101"));
    }

    public static int numSteps(String s) {
        int steps = 0;
        int carry = 0;
        for(int i=s.length()-1;i>0;i--){
            int digit = s.charAt(i)-'0'+carry;
            if(digit==1){
                steps+=2; // we have two steps add 1 to the number and then divide by 2 which is a right shift opeerator
                //We are adding one to a odd number
                carry=1;
            }else{
                steps+=1;//Since it is an even number we need to divide by 2
                if(digit==2){
                    carry=1;
                }
            }
        }
        //say if we have carry 1 we would eventually need to divide the number by 2 as 1+1 is 10 which is 2 and takes one step for division
        return steps+carry;
    }
}
