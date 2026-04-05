package Topics.String;

public class LC657 {

    public static void main(String[] args) {
        String s = "RL";
        System.out.println(judgeCircle(s));
    }

    public static boolean judgeCircle(String moves) {
        int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int[] t = new int[]{0,0};
        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i)=='L'){
                t[0] +=dir[0][0];
                t[1] +=dir[0][1];
            }else if(moves.charAt(i)=='R'){
                t[0] +=dir[1][0];
                t[1] +=dir[1][1];
            }else if(moves.charAt(i)=='U'){
                t[0] +=dir[2][0];
                t[1] +=dir[2][1];
            }else if(moves.charAt(i)=='D'){
                t[0] +=dir[3][0];
                t[1] +=dir[3][1];
            }
        }
        return t[0]==0 && t[1]==0;
    }

    public boolean judgeCircleOpti(String moves){
        int[] ch = new int[26];
        for (char move : moves.toCharArray()){
            ch[move - 'A']++;
        }
        return ch['U' - 'A'] == ch['D' - 'A'] &&
                ch['L' - 'A'] == ch['R' - 'A'];
    }
}
