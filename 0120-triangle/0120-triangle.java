class Solution {
    public static int dfs(int row,int col,int n,List<List<Integer>> triangle,int[][] dp){
        if(row==n-1)return triangle.get(row).get(col);
        if(dp[row][col]!=-1)return dp[row][col];
        int down=triangle.get(row).get(col)+dfs(row+1,col,n,triangle,dp);
        int dig=triangle.get(row).get(col)+dfs(row+1,col+1,n,triangle,dp);
        return dp[row][col]=Math.min(down,dig);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp=new int[triangle.size()][triangle.size()];
        for(int[] l:dp){
            Arrays.fill(l,-1);
        }
        return dfs(0,0,triangle.size(),triangle,dp);
    }
}