package Daily;

import java.util.LinkedList;
import java.util.Queue;

public class LC1598 {

    public static void main(String[] args) {

    }

    public int minOperations(String[] logs) {
        Queue<String> queue = new LinkedList<>();
        for(int i=0;i<logs.length;i++){
            int idx = logs[i].indexOf('/');
            String s = logs[i].substring(0,idx);
            if(s.equals("..") && !queue.isEmpty()){
                queue.poll();
            }
            else if(!s.equals(".") && !s.equals("..")){
                queue.offer(s);
            }
        }
        return queue.size();
    }

    public int minOperationsReudceSpace(String[] logs) {
        int c = 0;
        for(int i=0;i<logs.length;i++){
            String s = logs[i];
            if(s.equals("../") && c!=0){
                c--;
            }
            else if(!s.equals("./") && !s.equals("../")){
                c++;
            }
        }
        return c;
    }
}
