package Daily;

public class LC1513 {

    public int numSub(String s) {
        long c= 0;
        long res = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                c++;
            }
            else {
                res += (c*(c+1))/2;
                res = res = res%1000000007;
                c = 0;
            }
        }
        res += (c*(c+1))/2;
        res = res = res%1000000007;
        return (int)res;
    }
}
