package Daily;

import java.util.Arrays;

public class LC2326 {
    public static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        spiralMatrixOpti(3,5,head);
    }

    public static int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] mat = new int[m][n];
        for(int[] p:mat){
            Arrays.fill(p,-1);
        }
        ListNode cur = head;
        int i=0,j=0;
        int rowStart=0,rowEnd =n-1 ,colStart = 0,colEnd = m-1;
        while(cur!=null){

            //Iterate the row in inceasing order
            while(j<=rowEnd && cur!=null){
                mat[colStart][j] = cur.val;
                cur = cur.next;
                j++;
            }
            colStart++;
            i = colStart;
            //Iterate the columm in increasing order after movving to the next row
            while(i<=colEnd  && cur!=null){
                mat[i][rowEnd] = cur.val;
                cur = cur.next;
                i++;
            }
            rowEnd--;
            j=rowEnd;
            //Iterate the row in decreasing order after moving one less
            while(j>=rowStart  && cur!=null){
                mat[colEnd][j] = cur.val;
                cur = cur.next;
                j--;
            }
            colEnd--;
            i = colEnd;
            //Iterate the column in decreasing order
            while(i>=colStart  && cur!=null){
                mat[i][rowStart] = cur.val;
                cur = cur.next;
                i--;
            }
            rowStart++;
            j = rowStart;

        }
        return mat;
    }


    public static int[][] spiralMatrixOpti(int m, int n, ListNode head) {
        int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int idx = 0;
        ListNode cur = head;
        int i = 0,j = 0, newI = 0,newJ = 0;

        int[][] mat = new int[m][n];
        for (int[] row : mat) {
            Arrays.fill(row, -1);
        }
        while(cur!=null){
            mat[i][j] = cur.val;
            newI = i+dir[idx][0];
            newJ = j+dir[idx][1];
            if(newI>=m || newJ>=n || Math.min(newI,newJ)<0 || mat[newI][newJ] !=-1){
                idx = (idx+1)%4;
            }
            i +=dir[idx][0];
            j +=dir[idx][1];

//            cur = cur.next;
        }
        return mat;
    }
}
