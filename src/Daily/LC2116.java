package Daily;

import java.util.Stack;

public class LC2116 {

    public static void main(String[] args) {
        String s = "))()))", locked = "010100";
        String p = "())(()(()(())()())(())((())(()())((())))))(((((((())(()))))(" ,lock="100011110110011011010111100111011101111110000101001101001111";
        System.out.println(canBeValid(p,lock));
    }

    public static boolean canBeValid(String s, String locked) {
        if(s.length()%2!=0) return false;
        Stack<Integer> open = new Stack<>();
        Stack<Integer> unlocked = new Stack<>();

        for(int i=0;i<s.length();i++){
            if(locked.charAt(i)=='0'){
                unlocked.push(i);
            }else if(s.charAt(i)=='('){
                open.push(i);
            }else if(s.charAt(i)==')'){
                if(!open.isEmpty()){
                    open.pop();
                }else if(!unlocked.isEmpty()){
                    unlocked.pop();
                }else{
                    return false;
                }
            }
        }

        while(!open.isEmpty() && !unlocked.isEmpty() &&open.peek() < unlocked.peek()){
            open.pop();
            unlocked.pop();
        }

        if(!open.isEmpty()) return false;

        return true;
    }

    public static boolean canBeValidSpace(String s, String locked) {
        if(s.length()%2!=0) return false;
        int open = 0;
        int unlocked = 0;
        //Use to check only for locked open and close characters
        for(int i=0;i<s.length();i++){
            if(locked.charAt(i)=='0'){
                unlocked++;
            }else if(s.charAt(i)=='('){
                open++;
            }else if(s.charAt(i)==')'){
                if(open>0){
                    open--;
                }else if(unlocked>0){
                    unlocked--;
                }else return false;
            }
        }

        int balance = 0;
        //Only for open brackets
        for(int i=s.length()-1;i>=0;i--){
            if(locked.charAt(i)=='0'){
                balance--;
                unlocked--;
            }
            else if(s.charAt(i)=='('){
                open--;
                balance++;
            }
            else if(s.charAt(i)==')'){
                //Closing bracked are completly handled on top if you see so dont worry about not decrementing the count here balance is only decremented for open brackers
                balance--;
            }
            if(balance>0) return false;
            if(unlocked ==0 && open ==0) return true;
        }
        if(open>0) return false;
        return true;
    }
}
