class Solution {
    
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n+1][n+1];
        // for(int i=n-1;i>=0;i--)dp[n][i]=0;
        for(int ind=n-1;ind>=0;ind--){
            for(int prev=n-1;prev>=-1;prev--){
                int not_pick=dp[ind+1][prev+1];
                int pick=0;
                if(prev==-1 || nums[ind]>nums[prev]){
                    pick=1+dp[ind+1][ind+1];
                }
                
                dp[ind][prev+1]=Math.max(pick,not_pick);
            }
        }
        return dp[0][0];
    }
}