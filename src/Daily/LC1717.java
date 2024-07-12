package Daily;

import java.util.Stack;

public class LC1717 {


    public static void main(String[] args) {
        System.out.println( maximumGain("cdbcbbaaabab",4,5));

   }


   /*
   * Two pass solution
   *
   *
   * */
    public static int maximumGainTwoPass(String s, int x, int y) {
        int totalPoints = 0;
        String higherPoints = x>y?"ab":"ba";
        String lowerPoints = x<y?"ab":"ba";
        String afterfirstPass = removeSubstring(s,higherPoints);
        int pairs = (s.length()-afterfirstPass.length())/2;
        totalPoints += pairs* Math.max(x,y);
        String aftersecondPass = removeSubstring(afterfirstPass,lowerPoints);
        pairs = (afterfirstPass.length()-aftersecondPass.length())/2;
        totalPoints += pairs * Math.min(x,y);
        return totalPoints;
    }

    public static String removeSubstring(String s,String targetString){
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == targetString.charAt(1) && !stack.isEmpty() && stack.peek()==targetString.charAt(0)){
                stack.pop();
            }
            else stack.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        for(char c:stack){
            sb.append(c);
        }
        return sb.toString();
    }





    /*
      One pass solution getting rid of Stack and replaceing using read and write index
      this is still 0(n) space in java cause of String pool concept but in c is o(1) space
     */
    public static int maximumGainB(String s, int x, int y) {
        int totalPoints = 0;
        StringBuilder text = new StringBuilder(s);
        if(x>y){
            totalPoints+=calculatePoints(text,"ab",x);
            totalPoints+=calculatePoints(text,"ba",y);
        }else{
            totalPoints+=calculatePoints(text,"ba",y);
            totalPoints+=calculatePoints(text,"ab",x);
        }
        return totalPoints;
    }
    public static int calculatePoints(StringBuilder text,String target,int point){
        int totalPoints =0;
        int writeIdx =0;
        for(int readIdx=0;readIdx<text.length();readIdx++){
            text.setCharAt(writeIdx++,text.charAt(readIdx));
            if(writeIdx>1 &&text.charAt(writeIdx-2)==target.charAt(0) && text.charAt(writeIdx-1) ==target.charAt(1)){
                writeIdx=writeIdx-2;
                totalPoints+=point;
            }
        }
        text.setLength(writeIdx);
        return totalPoints;
    }


    /*
    * One pass solution changing input to favour us.
    * baaarbbb
    *
    * */
    public static int maximumGain(String s, int x, int y) {
        int totalPoints = 0;
        if(x<y){
            int temp = x;
            x = y;
            y = temp;
            s = new StringBuilder(s).reverse().toString();
        }
        int countA = 0;
        int countB = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='a'){
                countA++;
            }
            else if(ch=='b'){
                if(countA>0){
                    countA--;
                    totalPoints+=x;
                }else{
                    countB++;
                }
            }else{
                //If we have any other element time to calculate points from the ba part since we already
                //accounted for ab we can now account for ba
                totalPoints += y * Math.min(countA,countB);
                countA = countB =0;
            }
        }
        //Imagine "baabab" no new characters show up we still need to calculate "ba"
        totalPoints += y * Math.min(countA,countB);
        return totalPoints;
    }



}
