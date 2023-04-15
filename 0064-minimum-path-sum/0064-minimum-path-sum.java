class Solution {
    public static int help(int[][]grid,int start,int end,int n, int m,int[][] dp){
        if(start>n || end>m)return (int)1e9;
        if(n==start && m==end)return grid[n][m];
        if(dp[start][end]!=-1) return dp[start][end];
        int rightsum=grid[start][end]+help(grid,start,end+1,n,m,dp);
        int downsum=grid[start][end]+help(grid,start+1,end,n,m,dp);
        
        return dp[start][end]=Math.min(rightsum,downsum);
        
        
    }
    public int minPathSum(int[][] grid) {
        int [][] dp= new int [grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                dp[i][j]=-1;
            }
        }
        int ans=help(grid,0,0,grid.length-1,grid[0].length-1,dp);
        return ans;
    }
}