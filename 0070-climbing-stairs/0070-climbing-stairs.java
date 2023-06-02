class Solution {
    public static int dfs(int n,int[] dp){
        if(n==0 || n==1)return 1;
        if(dp[n]!=-1)return dp[n];
        int left=dfs(n-1,dp);
        int right=dfs(n-2,dp);
        return dp[n]=left+right;
    }
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        for(int i=0;i<=n;i++){
            dp[i]=-1;
        }
        return dfs(n,dp);
    }
}