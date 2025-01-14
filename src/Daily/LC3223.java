package Daily;

public class LC3223 {

    public static void main(String[] args) {
        System.out.println(minimumLength("aa"));
    }

    public static int minimumLength(String s) {
        int[] count = new int[26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
        }
        int sum = 0;
        for(int i=0;i<26;i++){
            if(count[i]>=3){
                int temp = count[i];
                while(temp/3!=0){
                    temp = temp%3 + temp/3;
                }
                count[i] = temp;
            }
            sum +=count[i];
        }
        return sum;
    }
}
