class Solution {
    public static void dfs(int[][] nums,int[][] vis ,int row,int col,int i){
        if(row>nums.length-1 || row<0  ||col<0|| col>nums[0].length-1 || vis[row][col]==1)return ;
        vis[row][col]=1;
        nums[row][col]=i;
        i++;
        if(row<=col+1){
            dfs(nums,vis,row,col+1,i);
        }
        dfs(nums,vis,row+1,col,i);
        dfs(nums,vis,row,col-1,i);
        dfs(nums,vis,row-1,col,i);
        
    }
    public int[][] generateMatrix(int n) {
        int [][] vis=new int [n][n];
        int [][] l=new int[n][n];
        dfs(l,vis,0,0,1);
        return l;
    }
}