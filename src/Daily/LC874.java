package Daily;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//-2: Turn left 90 degrees.
//-1: Turn right 90 degrees
public class LC874 {
    public static void main(String[] args) {

    }

    private int HASH_VALUE = 60001;

    public int robotSim(int[] commands, int[][] obstacles) {
        int idx = 0;
        int[] curPos = new int[]{0,0};
        Set<Integer> set = new HashSet<>();
        for(int[] o:obstacles){
            set.add(getHashValue(o[0],o[1]));
        }

                       //North, East, South, West
        int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int curDir = 0;
        int maxSqr = 0;
        for(int i=0;i<commands.length;i++){

            if(commands[i]==-1){
                //right
                curDir = (curDir+1)%4;
            }
            else if(commands[i]==-2){
                //left
                curDir = (curDir+3)%4;
            }

            int[] toUse = dir[curDir];
            for(int step=0;step<commands[i];step++){
                int nextX = curPos[0]+toUse[0];
                int nextY = curPos[1]+toUse[1];
                if(set.contains(getHashValue(nextX,nextY))){
                    break;
                }
                curPos[0] = nextX;
                curPos[1] = nextY;
            }
            maxSqr = Math.max(maxSqr,curPos[0]*curPos[0] +curPos[1]*curPos[1]);

        }


        return maxSqr;

    }

    private int getHashValue(int x, int y){
        return x + HASH_VALUE *y;
    }
}
