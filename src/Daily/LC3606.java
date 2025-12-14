package Daily;

import java.util.*;

public class LC3606 {

    public static void main(String[] args) {
        String[] code = new String[]{"SAVE20","","PHARMA5","SAVE@20"};
        String[] businessLine = new String[]{"restaurant","grocery","pharmacy","restaurant"};
        boolean[] isActive = new boolean[]{true,true,true,true};
        validateCoupons(code,businessLine,isActive);
    }

    public static List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> res = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        List<String> validBusinessLine = Arrays.asList("electronics", "grocery", "pharmacy", "restaurant");
        for(int i=0;i<code.length;i++){
            String cur = code[i];
            boolean valid = true;
            for(int k=0;k<cur.length();k++){
                if((cur.charAt(k) >=65 && cur.charAt(k)<=90) ||(cur.charAt(k)>=97 && cur.charAt(k)<=122) || (cur.charAt(k)>='0' && cur.charAt(k)<='9') ||cur.charAt(k)=='_'){
                    continue;
                } else {
                    valid = false;
                    break;
                }
            }
            if(!cur.isEmpty() &&  valid && validBusinessLine.contains(businessLine[i]) && isActive[i]){
                List<String> list = map.getOrDefault(businessLine[i],new ArrayList<>());
                list.add(cur);
                map.put(businessLine[i],list);
            }
        }

        for(int i=0;i<validBusinessLine.size();i++){
            List<String> val=  map.get(validBusinessLine.get(i));
            if(val!=null && !val.isEmpty()){
                Collections.sort(val);
                for(int j=0;j<val.size();j++){
                    res.add(val.get(j));
                }
            }
        }
        return res;
    }
}
