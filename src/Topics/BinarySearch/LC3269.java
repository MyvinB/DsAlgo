package Topics.BinarySearch;

public class LC3269 {

    public static void main(String[] args) {

    }

    public boolean check(long mid,int[] workerTimes,int mH){
        long height = 0;
        for(int i=0;i<workerTimes.length;i++){
            height+= Math.sqrt((2.0*mid)/workerTimes[i]+0.25) + 0.5;
            if(height>=mH) return true;
        }
        return false;
    }

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        int maxTime = Integer.MIN_VALUE;
        int n = workerTimes.length;
        for(int i=0;i<n;i++){
            maxTime = Math.max(maxTime,workerTimes[i]);
        }
        long l =1;
        long r = maxTime * mountainHeight * (mountainHeight+1)/2;
        long res = r;
        while(l<=r){
            long mid = l +(r-l)/2;
            if(check(mid,workerTimes,mountainHeight)){
                res=mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return res;
    }
}
