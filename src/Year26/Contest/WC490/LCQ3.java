package Year26.Contest.WC490;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LCQ3 {

    public static void main(String[] args) {

    }

    public String maximumXor(String s, String t) {
        List<Integer> oneList = new ArrayList<>();
        List<Integer> zeroList = new ArrayList<>();
        int n = s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i) == t.charAt(i)){
                if(s.charAt(i)=='0'){
                    zeroList.add(i);
                } else{
                    oneList.add(i);
                }
            }
        }
        char[] arr = t.toCharArray();
        Collections.sort(oneList);
        Collections.sort(zeroList);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            if(s.charAt(i)!=arr[i]){
                sb.append(s.charAt(i));
            }else{
                if(arr[i]==0){
                    if(!oneList.isEmpty()){
                        int val = oneList.get(0);
                        arr[i] = 1;
                        arr[i] = 0;
                        oneList.remove(i);

                    }
                }
            }
        }
        return null;
    }
}
