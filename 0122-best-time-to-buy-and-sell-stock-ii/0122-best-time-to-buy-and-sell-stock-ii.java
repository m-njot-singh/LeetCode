class Solution {
    public static int dfs(int ind,int buy,int[] prices,int[][] dp){
        if(ind==prices.length)return 0;
        if(dp[ind][buy]!=-1)return dp[ind][buy];
        int profit=0;
        if(buy==1){
            profit=Math.max((-prices[ind]+dfs(ind+1,0,prices,dp)),0+dfs(ind+1,1,prices,dp));
        }
        else{
            profit=Math.max((prices[ind]+dfs(ind+1,1,prices,dp)),0+dfs(ind+1,0,prices,dp));
        }
        return dp[ind][buy]=profit;
    }
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length+1][2];
        for(int i=0;i<2;i++)dp[prices.length][i]=0;
        for(int ind=prices.length-1;ind>=0;ind--){
            for(int buy=0;buy<2;buy++){
                
                int profit=0;
                if(buy==1){
                    profit=Math.max((-prices[ind]+dp[ind+1][0]),0+dp[ind+1][1]);
                }
                else{
                    profit=Math.max((prices[ind]+dp[ind+1][1]),0+dp[ind+1][0]);
                }
                dp[ind][buy]=profit;
            }
        }
        
        
        return dp[0][1];
        
    }
}