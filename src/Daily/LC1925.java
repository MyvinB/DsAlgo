package Daily;

import java.util.HashSet;
import java.util.Set;

public class LC1925 {


    public static void main(String[] args) {
        System.out.println(
                countTriples(5)
        );
    }

    public static int countTriples(int n) {
//        a2 + b2 = c2.
//
//        1,2,3,4,5
//        1 4 9 16 25

        int count = 0;
        for(int i=1;i<=n;i++){
            for(int j=i+1;j<=n;j++){
                int c = (int) Math.sqrt(i*i+j*j);
                if(c<=n && c*c == i*i + j*j){
                    count+=2;
                }
            }
        }
        return count;
    }
}
