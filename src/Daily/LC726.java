package Daily;

import javax.security.auth.callback.CallbackHandler;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class LC726 {


    public static void main(String[] args) {
        System.out.println(getCount("Be32"));
    }

    //HOrrible solution first thought
    public static String getCount(String s){
        Stack<String> stack = new Stack<>();
        int n = s.length();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push("(");
            }
            else if(s.charAt(i)==')'){
                StringBuilder sb = new StringBuilder();
                while(!stack.isEmpty() && !stack.peek().equals("(")){
                    sb.insert(0,stack.pop());
                }
                stack.pop();
                stack.push(sb.toString());
            }
            else if(Character.isDigit(s.charAt(i))){
                String rep = stack.pop();
                StringBuilder sb = new StringBuilder();
                int no = 0;
                while(i<n && Character.isDigit(s.charAt(i))){
                    no = Integer.parseInt(String.valueOf(s.charAt(i++)))+no*10;
                }
                i--;
                for(int t=0;t<no;t++){
                    sb.append(rep);
                }
                stack.push(sb.toString());
            }
            else{
                StringBuilder sb = new StringBuilder();
                do{
                    sb.append(s.charAt(i++));
                }while(i<n && s.charAt(i)!='(' && s.charAt(i)!=')' && !Character.isDigit(s.charAt(i)) && Character.isLowerCase(s.charAt(i)));
                i--;
                stack.push(sb.toString());
            }
        }
        System.out.println(stack);
        TreeMap<String,Integer> map = new TreeMap<>();
        for(String t:stack){
            int i =0;
            while(i<t.length()){
                StringBuilder sb = new StringBuilder();
                do{
                    sb.append(t.charAt(i++));
                }while(i<t.length() && Character.isLowerCase(t.charAt(i)));
                String key = sb.toString();
                map.put(key,map.getOrDefault(key,0)+1);
            }
        }
        System.out.println(map);
        StringBuilder sb = new StringBuilder();

        for(String k :map.keySet()){
            if(map.get(k)==1){
                sb.append(k);
            }else{
                sb.append(k+map.get(k));
            }

        }
        return sb.toString();
    }



    public String countOfAtoms(String formula) {
        Stack<Map<String,Integer>> stack = new Stack<>();
        stack.push(new HashMap<>());
        int len = formula.length();
        int start = 0;
        for(int i=0;i<len;){
            if(formula.charAt(i)=='('){
                stack.push(new HashMap<>());
                i++;
            }else if(formula.charAt(i)==')'){
                Map<String,Integer> topMap =stack.pop();
                i++;
                start = i;
                while(i<len && Character.isDigit(formula.charAt(i)))i++;
                int multiplier = start<i?Integer.parseInt(formula.substring(start,i)):1;
                for(String key:topMap.keySet()){
                    stack.peek().put(key, stack.peek().getOrDefault(key,0)+topMap.get(key)*multiplier);
                }
            }else{
                start = i;
                i++;
                while(i<len && Character.isLowerCase(formula.charAt(i)))i++;
                String element = formula.substring(start,i);
                start = i;
                while(i<len && Character.isDigit(formula.charAt(i)))i++;
                int count = start<i ?Integer.parseInt(formula.substring(start,i)):1;
                stack.peek().put(element,stack.peek().getOrDefault(element,0)+count);
            }
        }
        Map<String,Integer> result = stack.pop();
        List<String> res = new ArrayList<>(result.keySet());
        Collections.sort(res);
        StringBuilder sb = new StringBuilder();
        for(String a:res){
            sb.append(a);
            int count = result.get(a);
            if(count>1)sb.append(count);
        }

        return sb.toString();

    }
}
