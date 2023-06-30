class Solution {
    
    public static int dfs(int i,int n, int[] nums,int[] dp){
        if(i==n-1)return 0;
        if(dp[i]!=-1)return dp[i];
        int count=10000;
        for(int j=1;j<=nums[i] && i+j<n;j++){
            count=Math.min(count,1+dfs(i+j,n,nums,dp));
        }
        return dp[i]=count;
    }
    public int jump(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
       return dfs(0,nums.length,nums,dp);
        
    }
}