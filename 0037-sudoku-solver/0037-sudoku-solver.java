class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    
    public static boolean  solve(char [][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.'){
                    for(char c='1';c<='9';c++){
                        if(ifValid(board,i,j,c)){
                            board[i][j]=c;
                            if(solve(board)==true){
                                return true;
                            }else{
                                board[i][j]='.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    
    public static boolean ifValid(char [][] board,int i,int j,char c){
        for(int q=0;q<9;q++){
            if(board[i][q]==c)return false;
            
            if(board[q][j]==c)return false;
            
            if(board[3*(i/3)+q/3][3*(j/3)+q%3]==c)return false;
            
            
        }
        return true;
    }
}