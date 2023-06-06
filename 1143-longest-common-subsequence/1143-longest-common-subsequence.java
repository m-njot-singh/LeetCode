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
        int[] prev=new int[m+1];
        int[] curr=new int[m+1];
        for(int i=0;i<=m;i++)prev[i]=0;                  
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                
                if(s.charAt(i-1)==a.charAt(j-1))curr[j]=1+prev[j-1];
        
                else curr[j]=Math.max(prev[j],curr[j-1]);
                
            }
            prev=curr.clone();
        }
        return prev[m];
    }
}