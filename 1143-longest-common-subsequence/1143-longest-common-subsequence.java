class Solution {
    public static int solve(String s,String a,int i,int j,int [][] dp){
        if(i==s.length() || j==a.length())return 0;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=0;
        if(s.charAt(i)==a.charAt(j)){
            ans= 1+solve(s,a,i+1,j+1,dp);
            dp[i][j]=ans;
        }
        else{
            ans= Math.max(solve(s,a,i+1,j,dp),solve(s,a,i,j+1,dp));
            dp[i][j]=ans;
        }
        return dp[i][j];
        
    }
    public int longestCommonSubsequence(String s, String a) {
        int[][] dp=new int[s.length()][a.length()];
        for(int i=0;i<s.length();i++){
            for(int j=0;j<a.length();j++){
                dp[i][j]=-1;
            }
        }
        return solve(s,a,0,0,dp);
    }
}