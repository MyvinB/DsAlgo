package Topics.Arrays;

import java.util.ArrayList;
import java.util.List;

public class LC2069 {
}


class Robot {

    int idx = 0;
    int move = 0;
    List<int[]> pos = new ArrayList<>();
    public Robot(int width, int height) {

        //Go East to is 0 dir
        for(int x=0;x<width;x++){
            pos.add(new int[]{x,0,0});
        }
        //Go UP North is 1 dir
        for(int y=1;y<height;y++){
            pos.add(new int[]{width-1,y,1});
        }
        //for Wesr is 2
        for(int x=width-2;x>=0;x--){
            pos.add(new int[]{x,height-1,2});
        }

        for(int y=height-2;y>0;y--){
            pos.add(new int[]{0,y,3});
        }
        //Make 0,0 handling corner case
        pos.get(0)[2] = 3;
    }

    public void step(int num) {
        move = 1;
        idx = (idx+num)%pos.size();
    }

    public int[] getPos() {
        int[] arr = pos.get(idx);
        return new int[]{arr[0],arr[1]};
    }

    public String getDir() {
        int arr = pos.get(idx)[2];
        if(move==0) return "East";
        else if(arr==0) return "East";
        else if(arr==1) return "North";
        else if(arr==2) return "West";
        else if(arr==3) return "South";
        else return "";
    }
}
