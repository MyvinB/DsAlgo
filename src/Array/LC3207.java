package Array;

import java.util.Arrays;

public class LC3207 {

    public static void main(String[] args) {

    }

    public long maximumPoints(int[] enemyEnergies, int currentEnergy) {
        Arrays.sort(enemyEnergies);
        int minEnergy = enemyEnergies[0];
        if(enemyEnergies[0]>currentEnergy) return 0;
        int total = 0;
        for(int i=0;i<enemyEnergies.length;i++){
            total +=enemyEnergies[i];
        }
        //Excluding the minimum energy
        total -= enemyEnergies[0];
        total +=currentEnergy;
        return total/minEnergy;
    }
}
