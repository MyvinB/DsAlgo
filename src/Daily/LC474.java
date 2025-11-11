package Daily;

import java.util.ArrayList;
import java.util.List;

public class LC474 {

    public static void main(String[] args) {

    }

    public int findMaxForm(String[] strs, int m, int n) {
        List<int[]> list = new ArrayList<>();
        for(String s:strs){
            int one = 0;
            int zero = 0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='0'){
                    zero++;
                }
                else one++;
            }
            list.add(new int[]{zero,one});
        }
        int[][][] dp = new int[601][101][101];
        return dfs(list,m,n,0,dp);
    }


    public int dfs(List<int[]> countList, int nZero, int nOne, int index,int[][][] dp){
        //Base condition
        if(index==countList.size() || nZero ==0 && nOne == 0){
            return 0;
        }
        if(dp[index][nZero][nOne]!=0) return dp[index][nZero][nOne];
        int[] countAr = countList.get(index);
        //If we do not have the required zeros or ones we skip that element
        if(nZero<countAr[0] || nOne<countAr[1]){
            return dfs(countList,nZero,nOne,index+1,dp);
        }
        //Lets include the zero
        int include = 1 +dfs(countList,nZero-countAr[0],nOne-countAr[1],index+1,dp);
        int exclude = dfs(countList,nZero,nOne,index+1,dp);

        return dp[index][nZero][nOne] =Math.max(include,exclude);
    }
}
