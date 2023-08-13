class Solution {
    public static boolean rec(int i,int[]nums,int n,int[] dp){
        if(i>=n)return true;
        if(dp[i]!=-1){
            if(dp[i]==0)return false;
            return true;
        }
        
        boolean result=false;
        if(i+2<=n && nums[i]==nums[i+1]){
            result|=rec(i+2,nums,n,dp);
        }
        if(i+3<=n && nums[i]==nums[i+1] && nums[i+1]==nums[i+2]){
            result|=rec(i+3,nums,n,dp);
        }
        if(i+3<=n && nums[i+1]-nums[i]==1 && nums[i+2]-nums[i+1]==1){
            result|=rec(i+3,nums,n,dp);
        }
        if(result==false)dp[i]=0;
        else dp[i]=1;
        if(dp[i]==0)return false;
            return true;
    }
    public boolean validPartition(int[] nums) {
        int[] dp=new int[nums.length+1];
        Arrays.fill(dp,-1);
        return rec(0,nums,nums.length,dp);
    }
}