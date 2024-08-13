package Recursion;

import java.util.ArrayList;
import java.util.List;

public class LC22GenerateParentheses {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }


    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backTrack(n,"",0,0,res);
        return res;
    }

    public static void backTrack(int n,String temp,int open,int close,List<String> res){
        //Base condition
        if(open==close && open+close==2*n){
            res.add(temp);
            return;
        }
        if(open<n){
            backTrack(n,temp+"(",open+1,close,res);
        }
        if(close<open){
            backTrack(n,temp+")",open,close+1,res);
        }
    }


}
