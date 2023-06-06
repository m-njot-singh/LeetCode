class Solution {
    public static int solve(String s,String a,int i,int j,int [][] dp){
        if(i==0 || j==0)return 0;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        if(s.charAt(i-1)==a.charAt(j-1))return dp[i][j]= (1+solve(s,a,i-1,j-1,dp));
        
        return dp[i][j]=Math.max(solve(s,a,i-1,j,dp),solve(s,a,i,j-1,dp));
        
    }
    public int longestCommonSubsequence(String s, String a) {
        int n=s.length();
        int m=a.length();
        int[][] dp=new int[s.length()+1][a.length()+1];
        for(int i=0;i<=n;i++)dp[i][0]=0;
        for(int j=0;j<=m;j++)dp[0][j]=0;
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                
                if(s.charAt(i-1)==a.charAt(j-1))dp[i][j]=1+dp[i-1][j-1];
        
                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                
            }
        }
        return dp[n][m];
    }
}