package Daily;

import java.util.HashMap;

public class LC781 {

    public static void main(String[] args) {
        int[] t = new int[]{1,1,2};
        System.out.println(numRabbits(t));
    }

    public static int numRabbits(int[] answers) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<answers.length;i++){
            map.put(answers[i],map.getOrDefault(answers[i],0)+1);
        }
        int total =0;
        for(int key:map.keySet()){
            total+= Math.ceil((double)map.get(key)/(key+1))*(key+1);
        }
        return total;
    }
}
