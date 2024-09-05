package Daily;

public class LC1945 {

    public static void main(String[] args) {
//        System.out.println(getLucky("leetcode",2));
    }


    public int getLucky(String s, int k) {
        int sum = 0;
        k = k-1;
        for(int i=0;i<s.length();i++){
            int t = s.charAt(i)-'a' +1;
            sum+=getSum(t);
        }
        while(k!=0){
            sum= getSum(sum);
            k--;
        }
        return sum;
    }
    public int getSum(int t){
        int sum = 0;
        while(t!=0){
            sum+=t%10;
            t = t/10;
        }
        return sum;
    }

}
