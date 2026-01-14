package Daily;

public class LC3577 {

    public static void main(String[] args) {

    }

    public  int fact(int n){
        if(n==1) return 1;
        return  n * fact(n-1);
    }

    public int countPermutations(int[] complexity) {
        int minIndex = complexity[0];
        for(int i=1;i<complexity.length;i++){
            if(complexity[i]<=minIndex){
                return 0;
            }
        }
        return fact(complexity.length-1);
    }

}
