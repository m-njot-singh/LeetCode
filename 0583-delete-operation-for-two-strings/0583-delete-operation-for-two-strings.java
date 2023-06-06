class Solution {
    // public static int dfs(String s,String a,int i,int j,int[][] dp){
    //     if(i==0 || j==0)return 0;
    //     if(dp[i][j]!=-1)return dp[i][j];
    //     if(s.charAt(i-1)==a.charAt(j-1))return dp[i][j]=1+dfs(s,a,i-1,j-1,dp);
    //     return dp[i][j]=Math.max(dfs(s,a,i-1,j,dp),dfs(s,a,i,j-1,dp));
    // }
    public int minDistance(String s, String a) {
        if(s.equals(a))return 0;
        int n=s.length();
        int m=a.length();
        int[][] dp=new int[n+1][m+1];
        
        for(int i=0;i<=n;i++)dp[i][0]=0;
        for(int j=0;j<=m;j++)dp[0][j]=0;
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                
                 if(s.charAt(i-1)==a.charAt(j-1))dp[i][j]=1+dp[i-1][j-1];
                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                
            }
            // prev=(int[])(curr.clone());
        }
       
        
        int p=dp[n][m];
        int ans1=n-p;
        int ans2=m-p;
        
        return ans1+ans2;
    }
}