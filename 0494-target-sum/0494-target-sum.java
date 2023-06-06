class Solution {
       public int findTargetSumWays(int[] nums, int target) 
    {//Memoizaion ..
        int n = nums.length;
        int totalsum = 0;
        for(int i : nums)
            totalsum += i;
        int dp[][] = new int[n][Math.abs(target)+totalsum+1];
        for(int i[] : dp){
            Arrays.fill(i, -1);
        }
        return find(n-1, nums, target,dp);
    }
    public int find(int i, int[] nums, int target,int dp[][]) 
    {
        if(i < 0){
            if(target == 0)
                return 1;
            else
                return 0;
        }
        if(dp[i][Math.abs(target)] != -1)
            return dp[i][Math.abs(target)];
        int plus = find(i-1, nums, target + nums[i],dp);
        int minus = find(i-1, nums, target - nums[i],dp);
        
        return dp[i][Math.abs(target)] = plus + minus;
    }
}