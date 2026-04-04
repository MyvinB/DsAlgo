package Topics.String;

public class LC2075 {

    public static void main(String[] args) {
        String s = "iveo    eed   l te   olc";

        System.out.println(decodeCiphertext(s,4));

    }
    public static String decodeCiphertext(String encodedText, int rows) {
        if(encodedText.length()==0) return "";
        if(rows==1) return encodedText;
        int n = encodedText.length()/rows;
        char[][] grid = new char[rows][n];
        int k=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<n;j++){
                grid[i][j] = encodedText.charAt(k);
                k++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<n;t++){
            for(int i=0,j=t;i<rows && j<n;i++,j++){
                sb.append(grid[i][j]);
            }
        }
        int t = sb.length()-1;
        while(sb.charAt(t)==' '){
            t--;
        }
        return sb.toString().substring(0,t+1);

    }
}
