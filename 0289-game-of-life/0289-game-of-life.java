class Solution {
    
    
    public static int dfs(int i,int j,int n,int m,int[][] board,int[][] ans){
       int count=0;
        int[][] trav={{0,1},{1,0},{0,-1},{-1,0},{1,1},{-1,-1},{-1,1},{1,-1}};
        for(int[] it:trav){    
                if((i+it[0])<0 || (i+it[0])>=n || (j+it[1])<0 || (j+it[1])>=m )continue;
                if(board[i+it[0]][j+it[1]]==1)count++;
            }
       return count;
    }
    public void gameOfLife(int[][] board) {
        int n=board.length;
        int m=board[0].length;
        int[][] ans=new int[board.length][board[0].length];
    
        for(int q=0;q<n;q++){
            for(int w=0;w<m;w++){
               int count=dfs(q,w,n,m,board,ans);
                if(count<2)ans[q][w]=0;
                else if((count==2 || count==3)&&board[q][w]==1)ans[q][w]=1;
                else if(count>3 && board[q][w]==1)ans[q][w]=0;
                else if(count==3 && board[q][w]==0)ans[q][w]=1;
            }
        }
        
        
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j]=ans[i][j];
            }
        }
    }
}