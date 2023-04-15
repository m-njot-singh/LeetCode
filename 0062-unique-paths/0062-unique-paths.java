class Solution {
    public static int path(int row,int col,int n, int m,int[][] adj,int[][] dp){
        if(row<0 || col<0 || row>n || col>m )return 0;
        if(row==n && col==m)return 1;
        if(dp[row][col]!=-1)return dp[row][col];
        int down=path(row+1,col,n,m,adj,dp);
        int right=path(row,col+1,n,m,adj,dp);
        return dp[row][col]=down+right;
    }
    public int uniquePaths(int n, int m) {
        int[][] adj=new int[n][m];
        int [][] dp=new int [n][m];
        for(int i=0;i<adj.length;i++){
            for(int j=0;j<adj[0].length;j++){
                dp[i][j]=-1;
            }
        }
        return path(0,0,adj.length-1,adj[0].length-1,adj,dp);
        
    }
}