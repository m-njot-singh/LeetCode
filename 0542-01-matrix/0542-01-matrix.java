
class tuple{
    int i;
    int j;
    int d;
    tuple(int i,int j,int d){
        this.i=i;
        this.j=j;
        this.d=d;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        
        int[][] vis=new int[n][m];
        int[][] dis=new int[n][m];
        Queue<tuple> q=new LinkedList<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    vis[i][j]=1;
                    q.add(new tuple(i,j,0));
                }
                else{
                    vis[i][j]=0;
                }
            }
        }
        
        int nrow[]={0,1,-1,0};
        int ncol[]={1,0,0,-1};
        
        while(!q.isEmpty()){
            tuple it=q.peek();
            
            int i=it.i;
            int j=it.j;
            int d=it.d;
            
            q.remove();
            
            dis[i][j]=d;
            
            for(int w=0;w<4;w++){
                int row=i+nrow[w];
                int col=j+ncol[w];
                if(row>=0 && row<n && col>=0 && col<m && vis[row][col]==0){
                    vis[row][col]=1;
                    q.add(new tuple(row,col,d+1));
                }
            }
        }
        return dis;
    }
}