class Solution {
    public static int mod=(int)1e9+7;
    public static int dfs(int i,int j,int n,int m,int prev,int[][] grid,int[][] dp){
        if(i<0 || i>=n || j<0 || j>=m || prev>=grid[i][j])return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int down=dfs(i+1,j,n,m,grid[i][j],grid,dp);
        int up=dfs(i-1,j,n,m,grid[i][j],grid,dp);
        int left=dfs(i,j-1,n,m,grid[i][j],grid,dp);
        int right=dfs(i,j+1,n,m,grid[i][j],grid,dp);
        
        return dp[i][j]=(down+up+left+right+1)%mod;
    }
    public int countPaths(int[][] grid) {
        int ans=0;
        int n=grid.length;
        int m=grid[0].length;
        int[][] dp=new int[n][m];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
       for(int i=0;i<grid.length;i++){
           for(int j=0;j<grid[0].length;j++){
               ans=(ans+dfs(i,j,grid.length,grid[0].length,0,grid,dp))%mod;
           }
       }
        
        return ans;
    }
}