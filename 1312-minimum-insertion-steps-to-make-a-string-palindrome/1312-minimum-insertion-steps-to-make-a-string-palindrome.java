class Solution {
    public static int dfs(String s,String a,int i,int j,int[][] dp){
        if(i<0 || j<0)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(s.charAt(i)==a.charAt(j))return dp[i][j]=1+dfs(s,a,i-1,j-1,dp);
        return dp[i][j]=Math.max(dfs(s,a,i-1,j,dp),dfs(s,a,i,j-1,dp));
    }
    public int minInsertions(String s) {
        StringBuilder s1=new StringBuilder();
        s1.append(s);
        s1.reverse();
        String a=s1.toString();
        int[][] dp=new int[s.length()][s.length()];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        int p=dfs(s,a,s.length()-1,a.length()-1,dp);
        return s.length()-p;
    }
}