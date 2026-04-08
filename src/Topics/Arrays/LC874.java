package Topics.Arrays;

import java.util.HashSet;
import java.util.Set;

public class LC874 {


    public static void main(String[] args) {

    }
    public int HASH = 60001;
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] curPos = new int[]{0,0};
        Set<Integer> set = new HashSet<>();
        for(int[] x:obstacles){
            set.add(getHash(x[0],x[1]));
        }
        int curDir = 0;
        int maxSq = 0;
        //North, East, South West
        int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        for(int i=0;i<commands.length;i++){
            //East
            if(commands[i]==-1){
                curDir=(curDir+1)%4;
            }//West
            else if(commands[i]==-2){
                curDir=(curDir+3)%4;
            }
            for(int step=0;step<commands[i];step++){
                int nextX = curPos[0]+dir[curDir][0];
                int nextY = curPos[1]+dir[curDir][1];
                if(set.contains(getHash(nextX,nextY))){
                    break;
                }
                curPos[0] = nextX;
                curPos[1] = nextY;
            }

            maxSq = Math.max(maxSq,curPos[0]*curPos[0]+curPos[1]*curPos[1]);
        }
        return maxSq;
    }

    public int getHash(int x,int y){
        return x+HASH*y;
    }
}
