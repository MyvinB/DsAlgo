package Daily;

import java.util.HashMap;

public class LC3531 {

    public static void main(String[] args) {
        int[][] t = new int[][]{{2,4},{1,2},{3,1},{1,4},{2,3},{3,3},{2,2},{1,3}};
        System.out.println(countCoveredBuildings(t.length,t));
    }

    public static int countCoveredBuildings(int n, int[][] buildings) {
        HashMap<String,int[]> map = new HashMap<>();
        for(int i=0;i<buildings.length;i++){
            int x = buildings[i][0];
            int y = buildings[i][1];
            int[] tempValX = map.getOrDefault(x+"X",new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE});
            int[] tempValY = map.getOrDefault(y+"Y",new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE});
            int minY = Math.min(tempValX[0],y);
            int maxY = Math.max(tempValX[1],y);
            int minX = Math.min(tempValY[0],x);
            int maxX = Math.max(tempValY[1],x);
            map.put(x+"X",new int[]{minY,maxY});
            map.put(y+"Y",new int[]{minX,maxX});
        }
        int count = 0;
        for(int i=0;i<buildings.length;i++){
            int x = buildings[i][0];
            int y = buildings[i][1];
            if(map.containsKey(x+"X") && map.containsKey(y+"Y")){
                int[] tempValX = map.get(x+"X");
                int[] tempValY = map.get(y+"Y");
                if(x>tempValY[0] && x<tempValY[1] && y>tempValX[0] && y<tempValX[1]){
                    count++;
                }
            }
        }
        return count;
    }
}
