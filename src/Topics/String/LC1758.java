package Topics.String;

public class LC1758 {

    public static void main(String[] args) {
        System.out.println(minOperations("10010100"));
    }

    public static int minOperations(String s) {
        int n = s.length();
        if(n==0) return 0;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        int light = 0;
        if(s.charAt(0)=='0'){
            light = 0;
        } else {
            light = 1;
        }

        for(int i=0;i<n;i++){
            if(light==1){
                sb.append('1');
                sb1.append('0');
                light = 0;
            } else{
                sb.append('0');
                sb1.append('1');
                light = 1;
            }
        }
        int countA = 0;
        int countB = 0;
        for(int i=0;i<s.length();i++){
            if(sb.charAt(i)!=s.charAt(i)){
                countA++;
            }
            if(sb1.charAt(i)!=s.charAt(i)){
                countB++;
            }
        }

        return Math.min(countA,countB);
    }


    public static int minOperationsOp(String s){
        int start0 = 0;
        int start1 = 0;
        for(int i=0;i<s.length();i++){
            if(i%2==0){
                if(s.charAt(i)=='0'){
                    start1++;
                }else{
                    start0++;
                }
            }else{
                if(s.charAt(i)=='1'){
                    start1++;
                }else{
                    start0++;
                }
            }
        }

        return Math.min(start1,start0);
    }
}
