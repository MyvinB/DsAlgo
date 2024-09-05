package Daily;

public class LC2022 {


    public static void main(String[] args) {

    }


    public int[][] construct2DArray(int[] original, int m, int n) {
        int p = original.length;
        if(m*n!=p){
            return new int[][]{};
        }
        int[][] arr = new int[m][n];
        int k = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = original[k++];
            }
        }

        return arr;
    }
}
