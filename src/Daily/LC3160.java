package Daily;

import java.util.HashMap;
import java.util.HashSet;

public class LC3160 {

    public static void main(String[] args) {

    }

    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        int[] balls = new int[n];
        int[] res = new int[n];
        HashMap<Integer,Integer> colorCount = new HashMap<>();
        HashMap<Integer,Integer> ball = new HashMap<>();
        int distinct = 0;

        for(int i=0;i<queries.length;i++){
            int idx = queries[i][0];
            int col = queries[i][1];
            if(ball.containsKey(idx)){
                int cnt = colorCount.get(idx)-1;
                if(cnt == 0) distinct--;
                else colorCount.put(ball.get(idx),cnt);
            }
            ball.put(idx,col);
            int cnt = colorCount.getOrDefault(col,0)+1;
            colorCount.put(col,cnt);
            if(cnt==1) distinct++;
            res[i] = distinct;
        }
        return res;

    }


    public int[] queryResult1s(int limit, int[][] queries) {
        int n = queries.length;
        int[] balls = new int[n];
        int[] res = new int[n];
        HashMap<Integer,Integer> colorCount = new HashMap<>();
        HashMap<Integer,Integer> ball = new HashMap<>();
        int distinct = 0;

        for(int i=0;i<queries.length;i++){
            int idx = queries[i][0];
            int col = queries[i][1];
            if(ball.containsKey(idx)){
                int ballColor = ball.get(idx);
                int ballColorCount = colorCount.get(ballColor);

            }
            res[i] = distinct;
        }
        return res;

    }
}
