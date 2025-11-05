package Daily;

import java.util.*;

class Solution {
    private final class Entry{
        final int f;
        final int v;

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Entry entry = (Entry) o;
            return f == entry.f && v == entry.v;
        }

        @Override
        public int hashCode() {
            return Objects.hash(f, v);
        }

        private Entry(int f, int v) {
            this.f = f;
            this.v = v;
        }
    }

    private final Comparator<Entry> byFreqDescVal = (a,b)->{
        if (a.f!=b.f) return Integer.compare(b.f,a.f);
        return Integer.compare(b.v,a.v);
    };

    private HashMap<Integer,Integer> freqMap = new HashMap<>();
    private TreeSet<Entry> top,rest;
    private long curSum;

    private void insertVal(int v, int x){
        int f = freqMap.getOrDefault(v,0);

        if(f>0){
            Entry old = new Entry(f,v);
            if(top.remove(old)){
                curSum -= 1L * f * v;
            }else {
                rest.remove(old);
            }
        }
        f+=1;
        freqMap.put(v,f);
        Entry now = new Entry(f,v);
        top.add(now);
        curSum += 1L * f * v;
        if(top.size()>x){
            Entry smallestTop = top.last();
            curSum -= 1L * smallestTop.f * smallestTop.v;
            rest.add(smallestTop);
            top.remove(smallestTop);
        }


    }

    private void eraseVal(int v, int x){
        int f = freqMap.getOrDefault(v,0);
        if(f>0){
            Entry curEntry = new Entry(f,v);
            if(top.remove(curEntry)){
                curSum -= 1L * f * v;
            }else {
                rest.remove(curEntry);
            }
        }
        f-=1;
        if(f==0){
            freqMap.remove(v);
        }else{
            freqMap.put(v,f);
            rest.add(new Entry(f,v));
        }
        if(top.size()<x && !rest.isEmpty()){
            Entry bestRest = rest.first();
            rest.remove(bestRest);
            top.add(bestRest);
            curSum += 1L* bestRest.f * bestRest.v;
        }
    }

    public static void main(String[] args) {

    }

    public long[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int sz = n-k+1;
        long[] ans = new long[sz];
        freqMap = new HashMap<>(n*2);
        top = new TreeSet<>(byFreqDescVal);
        rest = new TreeSet<>(byFreqDescVal);
        curSum = 0L;

        for(int i=0;i<k;i++){
            insertVal(nums[i],x);
        }
        ans[0] = curSum;
        for(int l=1,r=k;r<n;l++,r++){
            eraseVal(nums[l-1],x);
            insertVal(nums[r],x);
            ans[l] = curSum;
        }
        return ans;
    }
}
