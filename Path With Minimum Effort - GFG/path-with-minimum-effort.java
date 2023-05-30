//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            int Grid[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] s = read.readLine().split(" ");
                for (int j = 0; j < M; j++) Grid[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.MinimumEffort(Grid));
        }
    }
}
// } Driver Code Ends

class Pair{
    int dist;
    int row;
    int col;
    Pair(int _dist,int _row,int _col){
        this.dist=_dist;
        this.row=_row;
        this.col=_col;
    } 
}
class Solution {
    
    int MinimumEffort(int heights[][]) {
        
        int n=heights.length;
        int m=heights[0].length;
        
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->x.dist-y.dist);
        pq.add(new Pair(0,0,0));
        
        int [][] dis=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dis[i][j]=(int)1e9;
            }
        }
        dis[0][0]=0;
        
        
        
        int delrow[]={1,0,-1,0};
        int delcol[]={0,-1,0,1};
        
        while(!pq.isEmpty()){
            Pair itr=pq.peek();
            pq.remove();
            int diff=itr.dist;
            int row=itr.row;
            int col=itr.col;
            
            if(row==n-1 && col==m-1)return diff;
            
            
            for(int i=0;i<4;i++){
                int newr=row+delrow[i];
                int newc=col+delcol[i];
                
                if(newr>=0 && newr<n && newc>=0 && newc<m ){
                    int E=Math.max(Math.abs(heights[row][col]-heights[newr][newc]),diff);
                    if(E<dis[newr][newc]){
                        dis[newr][newc]=E;
                        pq.add(new Pair(E,newr,newc));
                    }
                }
            }
            
        }
        return 0;
        
    }
}