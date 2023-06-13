class Solution {
    public static int dfs(int i,int n,int k,int[] arr,int[] dp){
        if(i==n)return 0;
        if(dp[i]!=-1)return dp[i];
        int max=Integer.MIN_VALUE;
        int len=0;
        int maxans=Integer.MIN_VALUE;
        for(int j=i;j<Math.min(n,i+k);j++){
            len++;
            max=Math.max(max,arr[j]);
            int sum=len*max+dfs(j+1,n,k,arr,dp);
            maxans=Math.max(maxans,sum);
        }
        return dp[i]=maxans;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp=new int[arr.length];
        Arrays.fill(dp,-1);
        return dfs(0,arr.length,k,arr,dp);
    }
}