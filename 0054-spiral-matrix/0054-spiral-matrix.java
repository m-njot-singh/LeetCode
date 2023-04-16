class Solution {
    public static void dfs(int [][]nums,List<Integer> l,int[][] vis ,int row,int col){
        if(row>nums.length-1 || row<0  ||col<0|| col>nums[0].length-1 || vis[row][col]==1)return ;
        vis[row][col]=1;
        l.add(nums[row][col]);
        if(row<=col+1){
            dfs(nums,l,vis,row,col+1);
        }
        dfs(nums,l,vis,row+1,col);
        dfs(nums,l,vis,row,col-1);
        dfs(nums,l,vis,row-1,col);
        
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        int [][] vis=new int [matrix.length][matrix[0].length];
        
        List<Integer> l=new ArrayList<>();
        dfs(matrix,l,vis,0,0);
        return l;
    }
}