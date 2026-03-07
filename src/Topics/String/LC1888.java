package Topics.String;

public class LC1888 {

    public static void main(String[] args) {
//        System.out.println(minFlips("001000000010"));
        System.out.println(slideIt("01001001101"));
    }

    public static int minFlips(String s) {
        StringBuilder sb = new StringBuilder();
        int minCount = Integer.MAX_VALUE;
        for(int i=0;i+1<s.length();i++){
            minCount = Math.min(getCount(s,0,i,s.length()-1),minCount);
        }
       return minCount;
    }


    public static int getCount(String s, int start, int mid, int end){
        int start0 = 0;
        int start1 = 0;
        int pos = 0;
        for(int i=mid;i<=end;i++){
            if(pos%2==0){
                if(s.charAt(i)=='0'){
                    start0++;
                }else{
                    start1++;
                }
            }else{
                if(s.charAt(i)=='0'){
                    start1++;
                }else{
                    start0++;
                }
            }
            pos++;
        }
        for(int i=start;i<mid;i++){
            if(pos%2==0){
                if(s.charAt(i)=='0'){
                    start0++;
                }else{
                    start1++;
                }
            }else{
                if(s.charAt(i)=='0'){
                    start1++;
                }else{
                    start0++;
                }
            }
            pos++;
        }
        return Math.min(start0,start1);
    }


    public static int slideIt(String s){
        int start0 = 0;
        int start1 = 0;
        int windowSize = s.length();
        s = s+s;

        int start = 0;
        int minCount = Integer.MAX_VALUE;
        for(int i=0;i<s.length();i++){
            if(i%2==0){
                if(s.charAt(i)=='0'){
                    start1++;
                }else{
                    start0++;
                }
            }else{
                if(s.charAt(i)=='0'){
                    start0++;
                }else{
                    start1++;
                }
            }
            while(i-start+1>windowSize){
                if(start%2==0){
                    if(s.charAt(start)=='0'){
                        start1--;
                    }else{
                        start0--;
                    }
                }else{
                    if(s.charAt(start)=='0'){
                        start0--;
                    }else{
                        start1--;
                    }
                }
                start++;
            }
            if(i-start+1==windowSize){
                minCount = Math.min(minCount,start0);
                minCount = Math.min(minCount,start1);
            }
        }
        return minCount;
    }
}
