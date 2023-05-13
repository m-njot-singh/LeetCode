class Solution {
    public static int ans=0;
    public static void dfs(int i,int j,int[][] grid,int count,int[][] vis){
        if(i<0 || i>grid.length-1 || j<0 || j>grid[0].length-1 || vis[i][j]==-1 || grid[i][j]==-1)return;

        if(grid[i][j]==2){
            if(count==0){
                ans++;
            }
            return;
        }
        vis[i][j]=-1;
        dfs(i+1,j,grid,count-1,vis);
        dfs(i-1,j,grid,count-1,vis);
        dfs(i,j+1,grid,count-1,vis);
        dfs(i,j-1,grid,count-1,vis);
        
        vis[i][j]=0;
    }
    public int uniquePathsIII(int[][] grid) {
        ans=0;
        int starti=0;
        int startj=0;
        int count=0;
        // int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0 || grid[i][j]==2){
                    count++;
                }
                if(grid[i][j]==1){
                    starti=i;
                    startj=j;
                }
                
            }
        }
        int[][] vis=new int[grid.length][grid[0].length];
         
        dfs(starti,startj,grid,count,vis);
        return ans;
    }
}