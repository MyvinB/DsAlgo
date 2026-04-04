package Topics.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LC3661 {

    public static void main(String[] args) {

    }

    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n = robots.length;
        List<int[]> robotDistance = new ArrayList<>();
        List<int[]> range = new ArrayList<>();
        for(int i=0;i<n;i++){
            robotDistance.add(new int[]{robots[i],distance[i]});
        }
        //sorted with robots position
        Collections.sort(robotDistance,(a,b)->Integer.compare(a[0],b[0]));
        Arrays.sort(walls);
        for(int i=0;i<n;i++){
            int pos = robotDistance.get(i)[0];
            int d = robotDistance.get(i)[1];

            //robotDistance left
            int leftLimit  = i==0?1:robotDistance.get(i-1)[0]+1;
            int rightLimit = i==n-1? (int) 1e9 :robotDistance.get(i+1)[0]-1;

            int L = Math.max(pos-d,leftLimit);
            int R = Math.min(pos+d,rightLimit);
            //RobotDistance right
            //robotDistance.get(i+1)[0]-1
            range.add(new int[]{L,R});
        }
        Integer[][] dp = new Integer[n][2];
        for(Integer[] a:dp){
            Arrays.fill(a,-1);
        }
        //prev ==0 (previous robot hit robot left if 1 it hit it right)
        return  solve(walls,robotDistance,range,0,0,dp);

    }

    int countWall(int[] walls,int left,int right){
        int l = 0;
        int r = walls.length-1;
        int target = left;
        int lowerBound = walls.length;
        int upperBound = walls.length;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(walls[mid]>=target){
                lowerBound = mid;
                r = mid-1;
            }else {
                l=mid+1;
            }
        }
        l = 0;
        r = walls.length-1;
        target =right;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(walls[mid]>target){
                upperBound = mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }

        return upperBound-lowerBound;
    }

    int solve(int[] walls,List<int[]> robotDistance,List<int[]> range,int i,int prevDir,Integer[][] dp){
        if(i==robotDistance.size()){
            return 0;
        }
        if(dp[i][prevDir]!=-1) return dp[i][prevDir];

        int leftStart = range.get(i)[0];
        if(prevDir==1 && i>0){
            leftStart=Math.max(leftStart,range.get(i-1)[1]+1);
        }
        int leftTake = countWall(walls,leftStart,robotDistance.get(i)[0]) + solve(walls,robotDistance,range,i+1,0,dp);

        int rightTake = countWall(walls,robotDistance.get(i)[0],range.get(i)[1]) + solve(walls,robotDistance,range,i+1,1,dp);
        return dp[i][prevDir]=Math.max(leftTake,rightTake);
    }
}
