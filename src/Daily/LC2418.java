package Daily;

import java.util.Arrays;
import java.util.HashMap;

public class LC2418 {

    public String[] sortPeople(String[] names, int[] heights) {
        int n = heights.length;
        Integer[] sortedIndex = new Integer[n];
        for(int i=0;i<names.length;i++){
            sortedIndex[i] = i;
        }

        Arrays.sort(sortedIndex,(a,b)->Integer.compare(heights[b],heights[a]));
        String[] namesSort = new String[n];
        for(int i =0;i<n;i++){
            namesSort[i] = names[sortedIndex[i]];
        }
        return namesSort;
    }
}
