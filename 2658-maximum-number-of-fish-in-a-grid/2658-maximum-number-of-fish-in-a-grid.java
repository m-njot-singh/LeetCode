class Solution {
    public static int dfs(int i,int j,int[][] grid,int [][] vis){
        if(i<0 || i>grid.length-1 || j<0 || j>grid[0].length-1 || vis[i][j]==1 || grid[i][j]==0)return 0;
        vis[i][j]=1;
        int ans=grid[i][j]+dfs(i+1,j,grid,vis)+dfs(i-1,j,grid,vis)+dfs(i,j+1,grid,vis)+dfs(i,j-1,grid,vis);
        return ans;
    }
    public int findMaxFish(int[][] grid) {
        int ans=0;
        int[][] vis=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]>0 && vis[i][j]==0){
                    ans=Math.max(ans,dfs(i,j,grid,vis));
                    
                }
            }
        }
        return ans;
    }
}