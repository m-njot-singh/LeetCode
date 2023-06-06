class Solution {
    // public static int dfs(int ind,int target,int[] coins,int[][] dp){
    //     if(ind==0){
    //         if(target%coins[ind]==0)return target/coins[ind];
    //         return (int)1e9;
    //     }
    //     if(dp[ind][target]!=-1)return dp[ind][target];
    //     int not_pick=0+dfs(ind-1,target,coins,dp);
    //     int pick=Integer.MAX_VALUE;
    //     if(coins[ind]<=target){
    //         pick=1+dfs(ind,target-coins[ind],coins,dp);
    //     }
    //     return dp[ind][target]=Math.min(not_pick,pick);
    // }
    public int coinChange(int[] nums, int target) {
        int n=nums.length;
        int[][] dp=new int[n][target+1];
            for(int i=0;i<=target;i++){
                if(i%nums[0]==0){
                    dp[0][i]=i/nums[0];
                }
                else{
                    dp[0][i]=(int)1e9;
                }
            }
        for(int ind=1;ind<n;ind++){
            for(int t=0;t<=target;t++){
                int not_pick=0+dp[ind-1][t];
        int pick=Integer.MAX_VALUE;
        if(nums[ind]<=t){
            pick=1+dp[ind][t-nums[ind]];
        }
        dp[ind][t]=Math.min(not_pick,pick);
            }
        }
        if(dp[n-1][target]==(int)1e9)return -1;
        return dp[n-1][target];
    }
}