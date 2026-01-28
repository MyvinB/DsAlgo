package Daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC1079 {

    private static int[] fact = new int[8];



    public int numTilePossibilities(String tiles) {
        preComputeFactorial();
        System.out.println(Arrays.toString(fact));
        char[] tilesArr = tiles.toCharArray();
        Arrays.sort(tilesArr);
        return generateSequence(tilesArr,"",0,new ArrayList<>());
    }


    //Naive


    private void preComputeFactorial(){
        fact[1] = 1;
        for(int i=2;i<fact.length;i++){
            fact[i] = fact[i-1]*i;
        }
    }

    public int countPermutations(String cur){
        int[] count = new int[26];
        for(int i=0;i<cur.length();i++){
            count[cur.charAt(i)-'A']++;
        }
        int total = fact[cur.length()];
        for(int i=0;i<26;i++){
            if(count[i]!=0){
                total = total/fact[count[i]];
            }
        }
        return total;
    }


    public int generateSequence(char[] tiles,String cur,int idx,List<String> list){
        if(idx==tiles.length){
            if(!list.contains(cur)){
                list.add(cur);
                return countPermutations(cur);
            }else return 0;
        }
        //Choose the particular index +    //Do not choose the partiuclar index
        return generateSequence(tiles,cur+tiles[idx],idx+1,list) + generateSequence(tiles,cur,idx+1,list);
    }


    //Naive solution

    public static void main(String[] args) {
//        System.out.println(numTilePossibilities("CDC"));
    }

    public static void recur(String tiles, StringBuilder sb,List<String> list,boolean[] isUsed){
        if(!list.contains(sb.toString())){
            list.add(sb.toString());
        }

        for(int i=0;i<tiles.length();i++){
            if(!isUsed[i]){
                isUsed[i]=true;
                sb.append(tiles.charAt(i));
                recur(tiles,sb,list,isUsed);
                sb.deleteCharAt(sb.length()-1);
                isUsed[i] = false;
            }
        }
    }
}
