class Solution {
    public static int dfs(int len,int[] dp,int low,int high,int zero,int one,long mod){
        int count=0;
        if(len>=low && len<=high){
            count++;
            // System.out.println(count);
        }
        else if(len>high){
            return 0;
        }
        if(dp[len]!=-1){
            return dp[len];
        }
        
        int a=dfs(len+zero,dp,low,high,zero,one,mod);
        // len-=zero;
        int b=dfs(len+one,dp,low,high,zero,one,mod);
        return dp[len]=(int)((count+a+b)%mod);
    }
    public int countGoodStrings(int low, int high, int zero, int one) {
        int count=0;
        long mod=(int)1e9+7;
        int [] dp=new int[high+1];
        for(int i=0;i<=high;i++){
            dp[i]=-1;
        }
        count=dfs(0,dp,low,high,zero,one,mod);
        return count;
    }
}