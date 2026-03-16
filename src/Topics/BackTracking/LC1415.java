package Topics.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class LC1415 {

    public static void main(String[] args) {
        System.out.println(getHappyString(3,9));
    }

    public static String getHappyString(int n, int k) {
        List<String> temp = new ArrayList<>();
        temp.add("a");
        temp.add("b");
        temp.add("c");
        List<String> res = new ArrayList<>();
        recur(n, new StringBuilder(),temp,res);
        if(k>res.size()) return "";
        return res.get(k-1);
    }


    public static void recur(int n, StringBuilder sb, List<String> temp,List<String> res){
        if(sb.length()==n){
            res.add(sb.toString());
            return;
        }
        for(int i=0;i<temp.size();i++){
            if(!sb.isEmpty()&& sb.charAt(sb.length()-1)!=temp.get(i).charAt(0) || sb.isEmpty()){
                sb.append(temp.get(i));
                recur(n,sb,temp,res);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
