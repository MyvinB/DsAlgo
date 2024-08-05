package Daily;

public class LC2976 {

    public static void main(String[] args) {
        char[] original = new char[]{'a','b','c','c','e','d'};
        char[] changed = new char[]{'b','c','b','e','b','e'};
        int[] cost = new int[]{2,5,5,1,2,20};
        System.out.println(minimumCost("abcd","acbe",original,changed,cost));


                
    }

    private static final int INF = (int)1e9;
    private static final int CHAR_COUNT = 26;

    public static long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int m = CHAR_COUNT;
        int len = original.length;
        int[][] matrix = new int[m][m];
        for(int i =0;i<m;i++){
            for(int j=0;j<m;j++){
                matrix[i][j] = INF;
            }
        }

        for(int i=0;i<len;i++){
            char u = original[i];
            char v = changed[i];
            int c = cost[i];
            //Already present with a better solution for the same conversion can also be present
            matrix[u-'a'][v-'a'] = Math.min(c,matrix[u-'a'][v-'a']);
        }

        for(int i=0;i<m;i++){
            matrix[i][i] = 0;
        }

        for(int k=0;k<m;k++){
            for(int i=0;i<m;i++){
                for(int j=0;j<m;j++){
                    if(matrix[i][k] == INF || matrix[k][j]==INF) continue;
                    matrix[i][j] = Math.min(matrix[i][j],matrix[i][k]+matrix[k][j]);
                }
            }
        }
        long total = 0;
        for(int i=0;i<source.length();i++){
            char u = source.charAt(i);
            char v = target.charAt(i);
            if(matrix[u-'a'][v-'a']==INF){
                return -1;
            }
            total+=matrix[u-'a'][v-'a'];
        }
        return total;
    }
}
