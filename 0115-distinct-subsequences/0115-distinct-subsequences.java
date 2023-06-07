class Solution {
    public static int dfs(String s,String a,int i,int j,int[][] dp){
        if(j<0)return 1;
        if(i<0)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(s.charAt(i)==a.charAt(j))return dp[i][j]=dfs(s,a,i-1,j-1,dp)+dfs(s,a,i-1,j,dp);
        return dp[i][j]=dfs(s,a,i-1,j,dp);
    }
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        int[][] dp=new int[n][m];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        return dfs(s,t,n-1,m-1,dp);
    }
}