class Solution {
    public static int dfs(String s,String a,int i,int j,int[][] dp){
        if(i==0 || j==0)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(s.charAt(i-1)==a.charAt(j-1))return dp[i][j]=1+dfs(s,a,i-1,j-1,dp);
        return dp[i][j]=Math.max(dfs(s,a,i-1,j,dp),dfs(s,a,i,j-1,dp));
    }
    public int minDistance(String word1, String word2) {
        if(word1.equals(word2))return 0;
        int n=word1.length();
        int m=word2.length();
        int[][] dp=new int[n+1][m+1];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        int p=dfs(word1,word2,n,m,dp);
        System.out.println(p);
        int ans1=n-p;
        int ans2=m-p;
        
        return ans1+ans2;
    }
}