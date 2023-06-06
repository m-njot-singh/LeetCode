class Solution {
    public static int dfs(int ind,int target,int[] coins,int[][] dp){
        if(ind==0){
            if(target%coins[ind]==0)return target/coins[ind];
            return (int)1e9;
        }
        if(dp[ind][target]!=-1)return dp[ind][target];
        int not_pick=0+dfs(ind-1,target,coins,dp);
        int pick=Integer.MAX_VALUE;
        if(coins[ind]<=target){
            pick=1+dfs(ind,target-coins[ind],coins,dp);
        }
        return dp[ind][target]=Math.min(not_pick,pick);
    }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
            for(int[] i:dp){
                Arrays.fill(i,-1);
            }
        int ans=dfs(n-1,amount,coins,dp);
        if(ans==(int)1e9)return -1;
        return ans;
    }
}