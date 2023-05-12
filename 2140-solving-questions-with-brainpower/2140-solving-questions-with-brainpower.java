class Solution {
    public static long dfs(int i,long[] dp,int[][] questions){
        long count=0;
        if(i>=questions.length){
            return count;
        }
        if(dp[i] != -1l){
            return dp[i];
        }
        count=questions[i][0];
        long a=dfs(i+questions[i][1]+1,dp,questions);
        long b=dfs(i+1,dp,questions);
        return dp[i]=Math.max(count+a,b);
    }
    public long mostPoints(int[][] questions) {
        long dp[]=new long[questions.length];
        for(int q=0;q<dp.length;q++){
            dp[q]=-1;
        }
       return dfs(0,dp,questions);
    }
}