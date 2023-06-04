class Solution {
    
    //  public static int dfs(int row,int col,int n,int m,int[][] matrix,int[][] dp){
    //     if(row<0 || row>=n || col<0 || col>=m )return (int)1e9;
    //     if(row==n-1)return matrix[row][col];
    //     if(dp[row][col]!=-1)return dp[row][col];
    //     int down=matrix[row][col] + dfs(row+1,col,n,m,matrix,dp);
    //     int downl=matrix[row][col] + dfs(row+1,col-1,n,m,matrix,dp);
    //     int downr=matrix[row][col] + dfs(row+1,col+1,n,m,matrix,dp);
    //     return dp[row][col]=Math.min(down,Math.min(downl,downr));
    // }
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int min=Integer.MAX_VALUE;
        int [][] dp=new int[n][m];
        // for(int[] l:dp){
        //     Arrays.fill(l,-1);
        // }
        for(int i=0;i<m;i++){
            dp[0][i]=matrix[0][i];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                int down=matrix[i][j]+dp[i-1][j];
                int downl=matrix[i][j];
                int downr=matrix[i][j];
               
               if(j>0)
                downl += dp[i-1][j-1];
                else
                downl = Integer.MAX_VALUE;
                if(j<m-1)
                downr += dp[i-1][j+1];
                else
                downr = Integer.MAX_VALUE;
                
                dp[i][j]=Math.min(down,Math.min(downl,downr));
            }
        }
        
        min=dp[n-1][0];
        for(int i=0;i<m;i++){
            min=Math.min(min,dp[n-1][i]);
        }
        return min;
    }
}