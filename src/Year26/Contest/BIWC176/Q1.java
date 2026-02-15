package Year26.Contest.BIWC176;

public class Q1 {

    public static void main(String[] args) {
        int[] t = new int[]{5,3,12,14,1,2,3,2,10,6,6,9,7,8,7,10,8,9,6,9,9,8,3,7,7,2};
        String[] s = new String[]{"a","b","c"};
        mapWordWeights(s,t);
    }

    public static String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();
        for(String w: words){
            int sum = 0;
            for(char c:w.toCharArray()){
                sum += weights[c-'a'];
            }
            sb.append((char)('z'-(sum%26)));
        }
        return sb.toString();
    }
}
