class Solution {
    public static int dfs(int ind,int buy,int[] prices,int fee,int[][] dp){
        if(ind>=prices.length)return 0;
        if(dp[ind][buy]!=-1)return dp[ind][buy];
        int profit=0;
        if(buy==1){
            profit=Math.max((-prices[ind]+dfs(ind+1,0,prices,fee,dp)),0+dfs(ind+1,1,prices,fee,dp));
        }
        else{
            profit=Math.max(((prices[ind]-fee)+dfs(ind+1,1,prices,fee,dp)),0+dfs(ind+1,0,prices,fee,dp));
        }
        return dp[ind][buy]=profit;
    }
    
    public int maxProfit(int[] prices, int fee) {
        int[][] dp=new int[prices.length][2];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        return dfs(0,1,prices,fee,dp);
    }
}