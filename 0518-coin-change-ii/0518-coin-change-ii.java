class Solution {
    public static int dfs(int ind,int target,int[] arr,int[][] dp){
        if(target==0)return 1;
        if(ind==0){
            if(target%arr[0]==0)return 1;
            return 0;
        }
        if(dp[ind][target]!=-1)return dp[ind][target];
        int not_pick=0+dfs(ind-1,target,arr,dp);
        int pick=0;
        if(arr[ind]<=target){
            pick=dfs(ind,target-arr[ind],arr,dp);
        }
        return dp[ind][target]=pick+not_pick;
    }
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
            for(int[] i:dp){
                Arrays.fill(i,-1);
            }
        return dfs(n-1,amount,coins,dp);
    }
}