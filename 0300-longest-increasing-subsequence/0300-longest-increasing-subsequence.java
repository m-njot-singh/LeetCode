class Solution {
    public static int dfs(int ind,int prev,int[] nums,int[][] dp){
        if(ind==nums.length)return 0;
        if(dp[ind][prev+1]!=-1)return dp[ind][prev+1];
        
        int not_pick=dfs(ind+1,prev,nums,dp);
        int pick=0;
        if(prev==-1 || nums[ind]>nums[prev]){
            pick=1+dfs(ind+1,ind,nums,dp);
        }
        
        return dp[ind][prev+1]=Math.max(pick,not_pick);
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n][n+1];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        return dfs(0,-1,nums,dp);
    }
}