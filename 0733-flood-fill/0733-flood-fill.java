class Solution {
    public static void dfs(int[][] ans,int[][]image,int sr,int sc,int color,int incolor){
        int n=image.length;
        int m=image[0].length;
        if(sr<0 || sc<0 || sr>=n || sc>=m ){
            return;
        }
        if(image[sr][sc]!=incolor || ans[sr][sc]==color){
            return ;
        }
        ans[sr][sc]=color;
        dfs(ans,image,sr+1,sc,color,incolor);
        dfs(ans,image,sr-1,sc,color,incolor);
        dfs(ans,image,sr,sc+1,color,incolor);
        dfs(ans,image,sr,sc-1,color,incolor);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] ans=image;
        int incolor=ans[sr][sc];
        dfs(ans,image,sr,sc,color,incolor);
        return ans;
    }
}