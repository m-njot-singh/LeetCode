class Solution {
    public static int solve(String s,String a,int i,int j,int [][] dp){
        if(i<0 || j<0)return 0;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        if(s.charAt(i)==a.charAt(j))return dp[i][j]= (1+solve(s,a,i-1,j-1,dp));
        
        return dp[i][j]=Math.max(solve(s,a,i-1,j,dp),solve(s,a,i,j-1,dp));
        
    }
    public int longestCommonSubsequence(String s, String a) {
        int[][] dp=new int[s.length()][a.length()];
        for(int i=0;i<s.length();i++){
            for(int j=0;j<a.length();j++){
                dp[i][j]=-1;
            }
        }
        return solve(s,a,s.length()-1,a.length()-1,dp);
    }
}