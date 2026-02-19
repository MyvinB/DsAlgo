package Topics.BitWise;

public class LC696 {

    public static void main(String[] args) {
        System.out.println(countBinarySubstrings("00110"));
    }

    public static int countBinarySubstrings(String s) {
        int z = 0;
        int o = 0;
        int total = 0;
        int i = 0;
        int n = s.length();
        while(i<n){
            z = 0;
            while(i<n && s.charAt(i)=='0') {
                z++;
                i++;
            }
            if(z==o){
                total+=z;
            }else{
                total+=Math.min(z,o);
            }
            o = 0;
            while(i<n && s.charAt(i)=='1'){
                o++;
                i++;
            }
            if(z==o){
                total+=z;
            }else{
                total+=Math.min(z,o);
            }
        }
        return total;
    }
}
