package Year26.Daily;

public class LC2967 {

    public static void main(String[] args) {

    }

    private static final int INF = (int)1e9;
    private static final int CHAR_COUNT = 26;

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int m = CHAR_COUNT;
        long[][] graph = new long[m][m];
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                graph[i][j]=i==j?0:INF;
            }
        }

        for(int i=0;i<original.length;i++){
            int u = original[i]-'a';
            int v = changed[i]-'a';
            long c = cost[i];
            //Already existing cost might be minimum directly.
            graph[u][v] = Math.min(c,graph[u][v]);
        }

        //Flod Warshal Algo:

        for(int k=0;k<m;k++){
            for(int i=0;i<m;i++){
                for(int j=0;j<m;j++){
                    if(graph[i][k]==INF || graph[k][j]==INF) continue;
                    long disUsingMidPont = graph[i][k] + graph[k][j];
                    graph[i][j] = Math.min(graph[i][j],disUsingMidPont);
                }
            }
        }
        long ans = 0;
        for(int i=0;i<source.length();i++){
            int u = source.charAt(i)-'a';
            int v = target.charAt(i)-'a';
            if(graph[u][v]==INF) return -1;
            ans+= graph[u][v];
        }
        return ans;

    }

}
