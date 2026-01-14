package Daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LC3433 {

//    ["MESSAGE","10","id1 id0"],["OFFLINE","11","0"],["MESSAGE","71","HERE"]
//    [["MESSAGE","2","HERE"],["OFFLINE","2","1"],["OFFLINE","1","0"],["MESSAGE","61","HERE"]]
    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("MESSAGE","10","id1 id0"));
        list.add(Arrays.asList("OFFLINE","11","0"));
        list.add(Arrays.asList("MESSAGE","71","HERE"));
        List<List<String>> p = new ArrayList<>();
        p.add(Arrays.asList("MESSAGE","2","HERE"));
        p.add(Arrays.asList("OFFLINE","2","1"));
        p.add(Arrays.asList("OFFLINE","1","0"));
        p.add(Arrays.asList("MESSAGE","61","HERE"));
        System.out.println(Arrays.toString(countMentions(3,p)));
    }

    public static int[] countMentions(int numberOfUsers, List<List<String>> events) {
        Collections.sort(events, (List<String> a, List<String> b)->{
            Integer p = Integer.valueOf(a.get(1));
            Integer q = Integer.valueOf(b.get(1));
            if(p.equals(q)){
                String typeA = a.get(0);
                String typeB = b.get(0);
                if(typeA.equals(typeB)) return 0;
                if(typeA.equals("OFFLINE")) return -1;
                else return 1;
            }
            return Integer.compare(p,q);
        });
        int[] mentionCount = new int[numberOfUsers];
        int[] timeStampArr = new int[numberOfUsers];
        for(int i=0;i<events.size();i++){
            List<String> event = events.get(i);
            String msg = event.get(0);
            int timestamp = Integer.valueOf(event.get(1));
            String ids = event.get(2);
            if(msg.equals("MESSAGE")){
               if(ids.equals("HERE")){
                   for (int k = 0; k < numberOfUsers; k++) {
                       if (timeStampArr[k] <= timestamp) {
                           mentionCount[k]++;
                       }
                   }
               }else if(ids.equals( "ALL")){
                   for (int k = 0; k < numberOfUsers; k++) {
                       mentionCount[k]++;
                   }
               }else {
                   String[] users = ids.split(" ");
                   for (String user : users) {
                       int idx = Integer.parseInt(user.substring(2));
                       mentionCount[idx]++;
                   }
               }
            } else if (msg.equals("OFFLINE")){
               int index = Integer.valueOf(ids);
               timeStampArr[index] = timestamp+60;
            }
        }
        return mentionCount;
    }
}
