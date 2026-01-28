package Daily;

import java.util.Stack;

public class LC2375 {


    public static void main(String[] args) {

    }

    public String smallestNumber(String pattern) {
        Stack<Integer> stack = new Stack<>();
        int num=1;
        for(int i=0;i<pattern.length();i++){
            char ch = pattern.charAt(i);
            if(ch=='I' && stack.isEmpty() || stack.peek()<num){
                stack.push(num);
                num++;
            }else if(ch=='D' && stack.isEmpty() || stack.peek()>num){

                if(stack.peek()>num){
                    stack.push(num);
                }else{
                    while(stack.peek()<num){
                         
                    }
                }
            }
        }
    }
}
