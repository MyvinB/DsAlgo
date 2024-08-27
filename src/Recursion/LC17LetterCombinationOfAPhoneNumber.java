package Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC17LetterCombinationOfAPhoneNumber {

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length()==0){
            return res;
        }
        HashMap<Integer,String> map = new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        recur(0,digits,"",res,map);
        return res;
    }

    public static void recur(int i,String digits,String temp, List<String> res,HashMap<Integer,String> map){
        if(i==digits.length()){
           res.add(temp);
           return;
        }
        int num = Integer.valueOf(digits.charAt(i)+"");
        for(char p:map.get(num).toCharArray()){
            recur(i+1,digits,temp+p,res,map);
        }
    }
}
