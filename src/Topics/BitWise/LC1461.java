package Topics.BitWise;

import java.util.HashSet;

public class LC1461 {

    public static void main(String[] args) {
        hasAllCodesOptimail("00110110",2);
    }

    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        HashSet<String> set = new HashSet<>();
        for(int i=0;i+k<n;i++){
            set.add(s.substring(i, i+k));
        }
        return set.size()==Math.pow(2,k);
    }

    // 00 01 10 11
    public static boolean hasAllCodesOptimail(String s, int k) {
        //total number of permutations is 2^k let us have that in the array.
        int req = 1 << k;//left shiting to reach 2 pow k
        //Array created for the same
        boolean[] seen = new boolean[req];
        int mask = req - 1; // we create a mask to keep the k most bits say
        //we have 100 ie now 011 the mask insures k significant bits
        //think of mask like a black cardboard with a hole where the hole is 1 and carboard is 0 so taking that as an example
        //101101 &
        //000111
        //000101 as we can see we get the last 3 bits so in our case we need k bits
        //100
        //  1
        //011 think of it like we borrow from the 1 from left and then everything after 1 gets added
        //0
        int hash = 0;
        for (int i = 0; i < s.length(); ++i) {
            hash = ((hash << 1) & mask) | (s.charAt(i) & 1);
            // 00 -> 0 at index 1  hash = 00 actual number is 0
            //000 & 011 0 | 1 so 01 at index 2 hash = 01 actual number is 1
            //010 & 011 010 | 1 011 so index 3 hash = 11 actual number is 3
            //110 & 011 010 | 0 so index 4 hash = 10 actual number is 2
            //we notice req is zero here so the number becomes all the elements in the arry is fileld.
            //notice we keep left shifting to make space for the new bit that comes the mask makes sure we take only k siginificant bits
            //if you think of it we are actually making an integer comparisions compared to string cause integer is just faster.

            if (i >= k - 1 && !seen[hash]) {
                seen[hash] = true;
                req--;
                if (req == 0) return true;
            }
        }

        return false;
    }
}
