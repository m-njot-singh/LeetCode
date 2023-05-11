class Pair{
    int i;
    int j;
    int d;
    Pair(int _i,int _j,int _d){
        this.i=_i;this.j=_j;this.d=_d;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] vis=new int[mat.length][mat[0].length];
        int[][] dis=new int[mat.length][mat[0].length];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=1;
                }
                else{
                    vis[i][j]=0;
                }
            }
        }
        
        int delrow[]={-1,0,1,0};
        int delcol[]={0,1,0,-1};
        while(!q.isEmpty()){
            int i=q.peek().i;
            int j=q.peek().j;
            int d=q.peek().d;
            q.remove();
            dis[i][j]=d;
            for(int w=0;w<4;w++){
                int nrow=i+delrow[w];
                int ncol=j+delcol[w];
                if(nrow>=0 && nrow<mat.length && ncol>=0 && ncol<mat[0].length && vis[nrow][ncol]==0 ){
                    vis[nrow][ncol]=1;
                    q.add(new Pair(nrow,ncol,d+1));
                }
            }
            
        }
        return dis;
    }
}