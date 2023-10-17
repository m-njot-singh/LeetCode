class Solution {
    public static int help(int[] nums,int[]dp,int i,int n){
        if(i>=n)return 1;
        if(dp[i]!=-1){
            
            return dp[i];
        }
        for(int j=1;j<=nums[i];j++){
            if(help(nums,dp,i+j,n)==1)return dp[i]=1;
            
        }
        return dp[i]=0;
    }
    public boolean canJump(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        int ans=help(nums,dp,0,nums.length-1);
        if( ans==1)return true;
        return false;
    }
}