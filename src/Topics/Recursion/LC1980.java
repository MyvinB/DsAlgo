package Topics.Recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LC1980 {


    public static void main(String[] args) {
        String[] t = new String[]{"01","10"};
//        System.out.println(findDifferentBinaryString(t));

        generate("", 2,new HashSet<>());
    }

    public static String findDifferentBinaryString(String[] nums) {
        List<String> list = new ArrayList<>();
        list.add("0");
        list.add("1");
        list = getPermutations(0,list,nums[0].length()-1);
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        for(int i=0;i<list.size();i++){
            if(!set.contains(list.get(i))){
                return list.get(i);
            }
        }
        return "";
    }



    public static List<String> getPermutations(int idx, List<String> res, int n){
        if(idx==n) return res;
        List<String> temp = new ArrayList<>();
        for(int i=0;i<res.size();i++){
              temp.add(res.get(i)+"0");
              temp.add(res.get(i)+"1");
        }
        res = new ArrayList<>();
        res.addAll(temp);
        return getPermutations(idx+1,res,n);
    }

    HashSet<String> numSet = new HashSet<>();

    private static String generate(String curr, int n, HashSet<String> numsSet) {
        if (curr.length() == n) {
            if (!numsSet.contains(curr)) {
                return curr;
            }

            return "";
        }

        String addZero = generate(curr + "0",n,numsSet);
        if (addZero.length() > 0) {
            return addZero;
        }

        return generate(curr + "1", n, numsSet);
    }

}
