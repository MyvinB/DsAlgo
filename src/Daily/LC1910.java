package Daily;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC1910 {


    public static void main(String[] args) {
        System.out.println(removeOccurrences("daabcbaabcbc","abc"));
    }

//    public String removeOccurrences(String s, String part) {
////        int start=0,end=0;
////        int i = 0;
////        char[] t = s.toCharArray();
////        while(i<t.length){
////            start = i;
////            end = i;
////            int strCount = 0;
////            while(end<part.length() && ( t[end]==part.charAt(end)|| t[end]=='*')){
////                if(t[end] == '*'){
////                    strCount++;
////                }
////                end++;
////            }
////            if((end-start-strCount)==part.length() && i<end){
////                t[i++] = '*';
////
////            }else i++;
////
////        }
//
//    }


    public static String removeOccurrences(String s, String part) {
        Stack<Character> stack = new Stack<>();
        int n = part.length()-1;
        int end = n;
        int t= 0;
        int size = 0;
        char[] str = s.toCharArray();
        for(int i=0;i<s.length();i++){
            stack.push(s.charAt(i));
            t = i;
            while(end>=0 && (str[t]==part.charAt(end) || str[t]=='*')){
                if(str[t]!='*'){
                    end--;
                }
                str[t] = '*';
                t--;
            }
            if(end ==-1){
                size = n;
                while(!stack.isEmpty() && size>=0){
                    stack.pop();
                    size--;
                }
            }
            end = n;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();

    }
}
