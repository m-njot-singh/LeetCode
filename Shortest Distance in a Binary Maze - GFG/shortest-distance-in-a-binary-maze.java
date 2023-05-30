//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair{
    int first;
    int second;
    int third;
    Pair(int _first,int _second,int _third){
        this.first=_first;
        this.second=_second;
        this.third=_third;
    }
}
class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        // Your code here
        int n=grid.length;
        int m=grid[0].length;
        if(source[0]==destination[0] && source[1]==destination[1])return 0;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(0,source[0],source[1]));
        int[][] dis=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                dis[i][j]=(int)1e9;
            }
        }
        dis[source[0]][source[1]]=0;
        int [] delrow={1,0,-1,0};
        int [] delcol={0,-1,0,1};
        
        while(!q.isEmpty()){
            Pair it=q.peek();
            q.remove();
            int dist=it.first;
            int row=it.second;
            int col=it.third;
            
            
            for(int i=0;i<4;i++){
                int nrow=row+delrow[i];
                int ncol=col+delcol[i];
                 if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m 
                && grid[nrow][ncol] == 1 && dist + 1 < dis[nrow][ncol]) {
                    dis[nrow][ncol] = 1 + dist;
                    if(nrow == destination[0] && 
                      ncol == destination[1]) return dist + 1; 
                    q.add(new Pair(1+dist, nrow, ncol)); 
                }
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m  && grid[nrow][ncol]==1 && dist+1<dis[nrow][col]){
                    dis[nrow][ncol]=dist+1;
                    if(nrow==destination[0] && ncol==destination[1]) return dist+1;
                    q.add(new Pair(dist+1,nrow,ncol));
                }
            }
            
        }
        
      
        return -1;
    }
}
