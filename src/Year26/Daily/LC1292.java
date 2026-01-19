package Year26.Daily;

public class LC1292 {

    public static void main(String[] args) {

    }

    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] prefixRow = new int[m][n+1];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                prefixRow[i][j+1] = prefixRow[i][j]+mat[i][j];
            }
        }
        int high = Math.max(m,n);
        int low = 1;
        int ans = 0;
        while(low<=high){
            int mid = low+(high-low)/2;
            boolean found = false;
            for(int i=0;i+mid<=m;i++){
                for(int j=0;j+mid<=n;j++){
                    if(check(i,j,prefixRow,threshold,mid)){
                        found= true;
                        break;
                    }
                }
            }
            if(found){
                ans = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return ans;
    }

    public boolean check(int row,int col,int[][] prefixRow,int threshold, int size){
        int sum = 0;
        for(int i=row;i<row+size;i++){
            sum += prefixRow[i][col+size]-prefixRow[i][col];
        }
        if(sum>threshold) return false;

        return true;
    }
}
