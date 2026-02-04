package Year26.Daily;

import java.util.Arrays;

public class LC3640 {


    public static void main(String[] args) {
        int[] t = new int[]{1,4,2,7};
        System.out.println(maxSumTrionic(t));
        System.out.println(maxSumTrionicBottomUpTabularDp(t));
    }

    static final long NEG = -1_000_000_000_000_000L;

    public static long maxSumTrionic(int[] nums) {
        int n = nums.length;
        Long[][] dp = new Long[n][4];
        return recurMemo(nums,0,0, dp);
    }


    public static long recurMemo(int[] nums,int curIdx, int trend, Long[][] dp){
        int n = nums.length;
        if(curIdx==n-1){
            if(trend==3){
                return nums[curIdx];
            } else return NEG;
        }
        int cur = nums[curIdx];
        int next = nums[curIdx+1];
        long take = NEG;
        long skip = NEG;

        if(dp[curIdx][trend]!= null){
            return dp[curIdx][trend];
        }

        if(trend==0){
            skip = recurMemo(nums,curIdx+1,trend,dp);
        }
        if(trend==0 && next>cur){
            take = Math.max(take,cur +recurMemo(nums,curIdx+1,1,dp));
        }
        else if(trend==1){
            if(next<cur){
                take = Math.max(take,cur + recurMemo(nums,curIdx+1,2,dp));
            } else if(next>cur){
                take = Math.max(take,cur + recurMemo(nums,curIdx+1,1,dp));
            }
        }
        else if(trend==2){
            if(next>cur){
                take = Math.max(take,cur+ recurMemo(nums,curIdx+1,3,dp));
            } else if(next<cur) {
                take = Math.max(take,cur + recurMemo(nums,curIdx+1,2,dp));
            }
        }
        else if(trend==3){
            if(next>cur){
                take = Math.max(take,cur+ recurMemo(nums,curIdx+1,3,dp));
            } else if(next<cur) {
                take = cur;
            }
            take = Math.max(cur,take);
        }
        return dp[curIdx][trend] = Math.max(take,skip);
    }


    public static long maxSumTrionicBottomUpTabularDp(int[] nums) {
        int n = nums.length;
        Long[][] dp = new Long[n][4];
        for(Long[] d:dp){
            Arrays.fill(d,NEG);
        }
        dp[n-1][3] = (long) nums[n-1];
        for(int i= n-2;i>=0;i--){
            int cur = nums[i];
            int next = nums[i+1];
            for(int trend=3;trend>=0;trend--){
                long take = NEG;
                long skip = NEG;
                if(trend==0){
                    skip = dp[i+1][trend];
                }
                if(trend==0 && next>cur){
                    take = Math.max(take,cur +dp[i+1][1]);
                }
                else if(trend==1){
                    if(next<cur){
                        take = Math.max(take,cur + dp[i+1][2]);
                    } else if(next>cur){
                        take = Math.max(take,cur + dp[i+1][1]);
                    }
                }
                else if(trend==2){
                    if(next>cur){
                        take = Math.max(take,cur+ dp[i+1][3]);
                    } else if(next<cur) {
                        take = Math.max(take,cur + dp[i+1][2]);
                    }
                }
                else if(trend==3){
                    if(next>cur){
                        take = Math.max(take,cur+ dp[i+1][3]);
                    } else if(next<cur) {
                        take = cur;
                    }
                    take = Math.max(cur,take);
                }
                dp[i][trend] = Math.max(take,skip);
            }
        }
        return dp[0][0];
    }


    public static long maxSumTrionicKadaneOpti(int[] nums) {
        long NEG = -1_000_000_000_000_000L;
        int n = nums.length;
        long incr = NEG;
        long decr = NEG;
        long incr2 = NEG;
        long ans = NEG;
        for(int i=1;i<n;i++){
            long newIncr = NEG;
            long newDecr = NEG;
            long newIncr2 = NEG;

            if(nums[i-1]<nums[i]){
                newIncr = Math.max(incr+nums[i],nums[i-1]+nums[i]); // extend, // start new
            }

            if(nums[i-1]>nums[i]){
                newDecr = Math.max(incr+nums[i],decr+nums[i]); // start dec after inc,// extend dec
            }

            if(nums[i-1]<nums[i]){
                newIncr2 = Math.max(decr+nums[i], incr2+nums[i]); //increasing after decreasing //extedn keep increasing.
            }
            incr = newIncr;
            decr = newDecr;
            incr2 = newIncr2;
            ans = Math.max(ans,incr2);
        }
        return ans;

    }
}
