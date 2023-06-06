class Solution {
    // public static int dfs(String s,String a,int i,int j,int[][] dp){
    //     if(i==0 || j==0)return 0;
    //     if(dp[i][j]!=-1)return dp[i][j];
    //     if(s.charAt(i-1)==a.charAt(j-1))return dp[i][j]=1+dfs(s,a,i-1,j-1,dp);
    //     return dp[i][j]=Math.max(dfs(s,a,i-1,j,dp),dfs(s,a,i,j-1,dp));
    // }
    public int minInsertions(String s) {
        StringBuilder s1=new StringBuilder();
        s1.append(s);
        s1.reverse();
        String a=s1.toString();
        int[] prev=new int[s.length()+1];
        int[] curr=new int[s.length()+1];
        
        for(int j=0;j<=s.length();j++)prev[j]=0;
        
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=s.length();j++){
                
                 if(s.charAt(i-1)==a.charAt(j-1))curr[j]=1+prev[j-1];
                else curr[j]=Math.max(prev[j],curr[j-1]);
                
            }
            prev=(int[])(curr.clone());
        }
       
        int p=prev[s.length()];
        return s.length()-p;
    }
}