package Year26.Daily;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LC3714 {

    public static void main(String[] args) {
        System.out.println(longestBalancedOptimised("accc"));
    }

    public static int longestBalanced(String s) {
        int a = 0,b= 0,c = 0;
        int n = s.length();
        int size = 1;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(s.charAt(j)=='a') a++;
                else if(s.charAt(j)=='b') b++;
                else c++;
                if(a!=0){
                    set.add(a);
                }
                if(b!=0){
                    set.add(b);
                }
                if(c!=0){
                    set.add(c);
                }
                if(set.size()==1) {
                    size = Math.max(size , j-i+1);
                }
                set = new HashSet<>();
            }
            a=0;b=0;c=0;
        }
        return size;
    }

    public static int longestBalancedOptimised(String s) {
        int a_Count = 0,b_Count = 0, c_Count = 0;
        int n = s.length();
        int size = 1;
        int count = 1;
        for(int i=0;i+1<n;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                count++;
                size = Math.max(count,size);
            } else count = 1;
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        //Pass A and B
        for(int i=0;i<n;i++) {
            if (s.charAt(i) == 'a') a_Count++;
            else if (s.charAt(i) == 'b') b_Count++;
            else{
                a_Count = 0;
                b_Count = 0;
                map = new HashMap<>();
                map.put(0,i);
                continue;
            }
            if(map.containsKey(a_Count-b_Count)){
                size = Math.max(size,i-map.get(a_Count-b_Count));
            }else{
                map.put(a_Count-b_Count,i);
            }
        }

        a_Count = 0;
        b_Count = 0;
        c_Count = 0;
        map = new HashMap<>();
        map.put(0,-1);

        //Pass B and C
        for(int i=0;i<n;i++) {
            if (s.charAt(i) == 'b') b_Count++;
            else if (s.charAt(i) == 'c') c_Count++;
            else{
                c_Count = 0;
                b_Count = 0;
                map = new HashMap<>();
                map.put(0,i);
                continue;
            }
            if(map.containsKey(b_Count-c_Count)){
                size = Math.max(size,i-map.get(b_Count-c_Count));
            }else{
                map.put(b_Count-c_Count,i);
            }
        }


        a_Count = 0;
        b_Count = 0;
        c_Count = 0;
        map = new HashMap<>();
        map.put(0,-1);

        //Pass C and A
        for(int i=0;i<n;i++) {
            if (s.charAt(i) == 'c') c_Count++;
            else if (s.charAt(i) == 'a') a_Count++;
            else{
                c_Count = 0;
                a_Count = 0;
                map = new HashMap<>();
                map.put(0,i);
                continue;
            }
            if(map.containsKey(c_Count-a_Count)){
                size = Math.max(size,i-map.get(c_Count-a_Count));
            }else{
                map.put(c_Count-a_Count,i);
            }
        }


        a_Count = 0;
        b_Count = 0;
        c_Count = 0;
        Map<String,Integer> mapI = new HashMap<>();
        mapI.put(0+"t"+0,-1);
        //A B and C
        for(int i=0;i<n;i++) {
            if (s.charAt(i) == 'a') a_Count++;
            else if (s.charAt(i) == 'b') b_Count++;
            else ++c_Count;
            String key = a_Count-b_Count+"t"+(b_Count-c_Count);
            if(mapI.containsKey(key)){
                size = Math.max(size,i-mapI.get(key));
            }else{
                mapI.put(key,i);
            }
        }
        return size;
    }
}
