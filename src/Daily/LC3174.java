package Daily;

public class LC3174 {

    public static void main(String[] args) {
        System.out.println(clearDigits("abc"));
    }


    public static String clearDigits(String s) {
        int d = 0,c=0;
        int n = s.length();
        char[] sArr = s.toCharArray();
        while(d<n){
            //first digit
            while(d<n && !Character.isDigit(s.charAt(d)))d++;
            if(d==n) break;
            c = d-1;
            while(c>=0 &&  sArr[c]=='*') c--;
            sArr[c] = '*';
            sArr[d] = '*';
            c=d;
            d++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<sArr.length;i++){
            if(sArr[i]!='*') sb.append(sArr[i]);
        }
        return sb.toString();
    }
}
