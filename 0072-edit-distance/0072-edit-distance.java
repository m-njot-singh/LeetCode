class Solution {
    public static int dfs(String s,String a,int i,int j,int[][] dp){
        if(i<0)return j+1;
        if(j<0)return i+1;
        if(dp[i][j]!=-1)return dp[i][j];
        if(s.charAt(i)==a.charAt(j))return dp[i][j]=0+dfs(s,a,i-1,j-1,dp);
        return dp[i][j]=Math.min(1+dfs(s,a,i-1,j,dp),Math.min(1+dfs(s,a,i,j-1,dp),1+dfs(s,a,i-1,j-1,dp)));
    }
    public int minDistance(String s, String a) {
        int n=s.length();
        int m=a.length();
        int[][] dp=new int[n][m];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        return dfs(s,a,n-1,m-1,dp);
    }
}