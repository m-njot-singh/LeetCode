class Solution {
    public static int ans=0;
    public static void dfs(int col,char[][] board) {
        if(col==board.length){
            ans++;
            return;
        }
        for(int row=0;row<board.length;row++){
            if(validate(row,col,board)){
                board[row][col]='Q';
                dfs(col+1,board);
                board[row][col]='.';
            }
        }
        
        
    }
    
    public static boolean validate(int row,int col,char[][]board){
        int boolrow=row;
        int boolcol=col;
        while(row>=0 && col>=0){
            if(board[row][col]=='Q')return false;
            col--;
            row--;
        }
        
        row=boolrow;
        col=boolcol;
        while(col>=0){
            if(board[row][col]=='Q')return false;
            col--;
        }
        
        row=boolrow;
        col=boolcol;
        while(col>=0 && row<board.length){
           if(board[row][col]=='Q')return false;
            row++;
            col--;
        }
        
        
        return true;
        
    }
    public int totalNQueens(int n) {
        char [][] board=new char[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
       ans=0;
        dfs(0,board);
        return ans;
    }
   
}