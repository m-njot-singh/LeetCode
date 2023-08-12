class Solution {
    public static int rec(int row,int col,int n,int m,int[][] obs,int[][] dp){
        if(row<0 || row>n || col<0 || col>m || obs[row][col]==1)return 0;
        if(row==n && col==m){
            return 1;
        }
        if(dp[row][col]!=-1)return dp[row][col];
        int down = rec(row+1,col,n,m,obs,dp);
        int right = rec(row,col+1,n,m,obs,dp);
        return dp[row][col]=down+right;
    }
    public int uniquePathsWithObstacles(int[][] obs) {
        int[][] dp=new int[obs.length+1][obs[0].length+1];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        return rec(0,0,obs.length-1,obs[0].length-1,obs,dp);
        
    }
}