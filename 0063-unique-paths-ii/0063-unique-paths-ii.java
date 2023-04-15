class Solution {
    public static int dfs(int row,int col,int n,int m,int[][] adj,int[][] dp){
        if(row<0 || col<0 || row>n || col>m || adj[row][col]==1)return 0;
        if(row==n && col==m)return 1;
        if(dp[row][col]!=-1)return dp[row][col];
        int down=dfs(row+1,col,n,m,adj,dp);
        int right=dfs(row,col+1,n,m,adj,dp);
        return dp[row][col]=down+right;
    }
    public int uniquePathsWithObstacles(int[][] adj) {
        int [][] dp=new int[adj.length][adj[0].length];
        for(int i=0;i<adj.length;i++){
            for(int j=0;j<adj[0].length;j++){
                dp[i][j]=-1;
            }
        }
        return dfs(0,0,adj.length-1,adj[0].length-1,adj,dp);
    }
}