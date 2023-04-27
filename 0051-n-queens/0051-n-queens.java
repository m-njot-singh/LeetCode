class Solution {
    public static void dfs(int col,char[][] board,List<List<String>> ans) {
        if(col==board.length){
            ans.add(construct(board));
            return;
        }
        for(int row=0;row<board.length;row++){
            if(validate(row,col,board)){
                board[row][col]='Q';
                dfs(col+1,board,ans);
                board[row][col]='.';
            }
        }
        
        
    }
    
    
    
    public static List<String> construct(char[][] board){
        List<String> res=new ArrayList<String>();
        for(int i=0;i<board.length;i++){
            String s=new String(board[i]);
            res.add(s);
        }
        return res;
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
    public List<List<String>> solveNQueens(int n) {
        char [][] board=new char[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        List<List<String>> ans=new ArrayList<List<String>>();
        dfs(0,board,ans);
        return ans;
    }
    
    
}