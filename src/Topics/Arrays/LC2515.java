package Topics.Arrays;

public class LC2515 {


    public static void main(String[] args) {
        String[] words = new String[]{"a","b","leetcode"};
        System.out.println(closestTarget(words,"leetcode",0));
    }

    public static int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int minDistance = Integer.MAX_VALUE;
        String[] wordNew = new String[2*n];
        for(int i=0;i<n;i++){
            wordNew[i] = words[i];
        }
        for(int i=n;i<2*n;i++){
            wordNew[i] = words[i-n];
        }
        int idx = startIndex;
        while(idx<2*n){
            if(wordNew[idx].equals(target)){
                break;
            }
            idx++;
        }
        if(idx!=2*n){
            minDistance = Math.min(minDistance,idx-startIndex);
        }
        idx = startIndex+n;
        while(idx>=0){
            if(wordNew[idx].equals(target)){
                break;
            }
            idx--;
        }
        if(idx!=-1){
            minDistance = Math.min(minDistance,startIndex+n-idx);
        }
        return minDistance==Integer.MAX_VALUE?-1:minDistance;
    }


    public static int closestTargetOpti(String[] words, String target, int startIndex) {
        int n = words.length;
        for(int step = 0;step<n;step++){
            int forward = (startIndex+step)%n;
            int backward = ((startIndex-step)+n)%n;
            if(words[forward].equals(target) || words[backward].equals(target)){
                return step;
            }
        }
        return -1;
    }

}
