class Solution {
    
    public static int dfs(int ind,int buy,int cap,int[] prices,int[][][] dp){
        if(cap==0)return 0;
        if(ind==prices.length)return 0;
        if(dp[ind][buy][cap]!=-1)return dp[ind][buy][cap];
        int profit=0;
        if(buy==1){
            profit=Math.max((-prices[ind]+dfs(ind+1,0,cap,prices,dp)),0+dfs(ind+1,1,cap,prices,dp));
        }
        else{
            profit=Math.max((prices[ind]+dfs(ind+1,1,cap-1,prices,dp)),0+dfs(ind+1,0,cap,prices,dp));
        }
        return dp[ind][buy][cap]=profit;
    }
    
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n][2][k+1];
        for(int[][] i:dp){
            for(int[] j:i){
                Arrays.fill(j,-1);
            }
            
        }
        return dfs(0,1,k,prices,dp);
    }
}