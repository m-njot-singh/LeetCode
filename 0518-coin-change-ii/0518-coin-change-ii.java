class Solution {
    public static int rec(int i,int amount,int[] coins,int n,int[][] dp){
        if(amount==0){
            return 1; 
        }
        if(i==n){
            return 0;
        }
        
        if(dp[i][amount]!=-1){
            return dp[i][amount];
        }
        
        int pick=0;
        if(coins[i]<=amount){
            pick=rec(i,amount-coins[i],coins,n,dp);
        }
        int not_pick=rec(i+1,amount,coins,n,dp);
        
        return dp[i][amount]=pick+not_pick;
        
    }
    public int change(int amount, int[] coins) {
        int[][] dp=new int[coins.length][amount+1];
        for(int[] it:dp)Arrays.fill(it,-1); 
        return rec(0,amount,coins,coins.length,dp);
    }
}