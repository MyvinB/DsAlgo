package Daily;

import java.util.Stack;

public class LC1190 {

    public static void main(String[] args) {
        System.out.println(reverseParenthesesEditorial("(ed(et(oc))el)"));
    }

    /*
    * Using wormhole technique time O(n)
    * */
    public static String reverseParenthesesOptimised(String s) {
        int n = s.length();
        Stack<Integer> opened = new Stack<>();
        int[] pair = new int[n];
        //Creating the wormhole
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                opened.push(i);
            }
            else if(s.charAt(i)==')'){
                int j = opened.pop();
                pair[j] = i;
                pair[i] = j;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0,d=1;i<s.length();i+=d){
            if(s.charAt(i)=='(' ||s.charAt(i)==')'){
                i=pair[i];
                d = -d;
            }
            else sb.append(s.charAt(i));
        }

        return sb.toString();
    }



    /*
    * Well Wriiten code using index from Editorial but still O(n^2) time
    * */
    public static String reverseParenthesesEditorial(String s) {
        Stack<Integer> openParenthesisIndex = new Stack<>();
        StringBuilder res = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('){
                openParenthesisIndex.push(res.length());
            }else if(ch==')'){
                int startIdx = openParenthesisIndex.pop();
                reverse(res,startIdx,res.length()-1);
            }
            else res.append(ch);
        }
        return res.toString();
    }

    private static void reverse(StringBuilder sb, int start, int end) {
        while(start<end){
            char temp = sb.charAt(start);
            sb.setCharAt(start++,sb.charAt(end));
            sb.setCharAt(end--,temp);
        }
    }

    //Code that I came up with still 0(n^2) but not as sweet as the editorial
    public static  String reverseParenthesesNaive(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                if(!sb.isEmpty()){
                    stack.push(sb.toString());
                    sb = new StringBuilder();
                }
                stack.push("(");
            }
            else if(s.charAt(i)==')'){
                if(!sb.isEmpty()){
                    stack.push(sb.toString());
                    sb = new StringBuilder();
                }
                StringBuilder temp = new StringBuilder();
                //Keep poping the stuff until we do not see an open bracket
                while(!stack.isEmpty() && !stack.peek().equals("(")){
                    //it needs to be inserted from the start
                    temp.insert(0,stack.pop());
                }
                //pop the open bracket
                stack.pop();
                //reverse the entire string and pop
                stack.push(temp.reverse().toString());

            }
            else sb.append(s.charAt(i));
        }
        //for any additional characters outside the bracket take this testcase "a(bcdefghijkl(mno)p)q" and debug
        if(!sb.isEmpty()){
            stack.push(sb.toString());
        }
        StringBuilder res = new StringBuilder();
        for(String i:stack){
            res.append(i);
        }

        return res.toString();

    }



}
