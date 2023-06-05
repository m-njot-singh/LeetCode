class Solution {
    public static boolean dfs(int ind,int k,int n,int[] nums,int[][] dp){
        if(k==0)return true;
        if(ind==0){
            return (nums[0]==k);
        }
        if(dp[ind][k]!=-1){
            if(dp[ind][k]==0)return false;
            return true;
        }
        boolean not_pick=dfs(ind-1,k,n,nums,dp);
        boolean pick=false;
        if(nums[ind]<=k){
            pick=dfs(ind-1,k-nums[ind],n,nums,dp);
        }
        if((not_pick||pick)==false){
            dp[ind][k]=0;
        }
        else{
            dp[ind][k]=1;
        }
        return not_pick||pick;
    }
    public boolean canPartition(int[] nums) {
        
        int n=nums.length;
        int k=0;
        for(int a:nums){
            k+=a;
        }
        if(k%2!=0)return false;
        System.out.println(k);
        k=k/2;
        int[][] dp=new int[n][k+1];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return dfs(n-1,k,n,nums,dp);
    }
}