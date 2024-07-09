package Daily;

import java.util.ArrayList;

public class LC1823 {

    public static void main(String[] args) {

    }
    /*
    n= 5 k= 2
    i = 0;
    index to remove = i+2-1;
     */

    // NAIVE o(n2) time and O(n) space
    public int findTheWinner(int n, int k) {
        ArrayList<Integer> circle = new ArrayList<>();
        for(int i=1;i<=n;i++){
            circle.add(i);
        }
        int idx= 0;
        while (circle.size()>1){
            int idxToRmv = (idx+k-1)%circle.size();
            circle.remove(idxToRmv);
            idx = idxToRmv;
        }
        return circle.get(0);
    }

    // Recursion

    public int findTheWinnerRecursion(int n, int k) {
        return solve(n,k)+1;
    }

    public int solve(int n,int k){
        //base case
        if(n==1) return 0;
        return (solve(n-1,k)+k)%n;
    }


}
