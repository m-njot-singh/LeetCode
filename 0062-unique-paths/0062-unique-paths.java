class Solution {
    // public static int path(int row,int col,int n, int m,int[][] adj,int[][] dp){
    //     if(row<0 || col<0 || row>n || col>m )return 0;
    //     if(row==n && col==m)return 1;
    //     if(dp[row][col]!=-1)return dp[row][col];
    //     int down=path(row+1,col,n,m,adj,dp);
    //     int right=path(row,col+1,n,m,adj,dp);
    //     return dp[row][col]=down+right;
    // }
    public int uniquePaths(int n, int m) {
        int [][] dp=new int [n][m];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i==0 && j==0){
                    dp[i][j]=1;
                    continue;
                }
                int down=0;
                if(i>0){
                    down=dp[i-1][j];
                } 
                int right=0;
                if(j>0){
                    right=dp[i][j-1];
                }
                dp[i][j]=down+right;
            }
            
        }
        return dp[n-1][m-1];
        
    }
}