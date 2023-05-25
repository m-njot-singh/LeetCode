//{ Driver Code Starts
// Initial Template for Java

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

            Solution ob = new Solution();
            int ans = ob.numberOfEnclaves(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static void dfs(int row,int col,int[][] vis,int [][] grid,int n,int m,int[] delrow,int[] delcol){
        vis[row][col]=1;
        for(int i=0;i<4;i++){
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
            // System.out.println("out"+nrow+" "+ncol);
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                // System.out.println(nrow+" "+ncol);
                dfs(nrow,ncol,vis,grid,n,m,delrow,delcol);
            }
        }
    }

    int numberOfEnclaves(int[][] grid) {

        // Your code here
        int n=grid.length;
        int m=grid[0].length;
        int [][] vis=new int[n][m];
        int delrow[]={1,0,-1,0};
        int delcol[]={0,-1,0,1};
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    count++;
                }
            }
        }
        for(int i=0;i<m;i++){
            if(vis[0][i]==0 && grid[0][i]==1){
                dfs(0,i,vis,grid,n,m,delrow,delcol);
                // System.out.println(1);
            }
            if(vis[n-1][i]==0 && grid[n-1][i]==1){
                dfs(n-1,i,vis,grid,n,m,delrow,delcol);
                // System.out.println(2);
            }
        }
        
        for(int j=0;j<n;j++){
            if(vis[j][0]==0 && grid[j][0]==1){
                // System.out.println(3);
                // System.out.println(j);
                dfs(j,0,vis,grid,n,m,delrow,delcol);
                
            }
            if(vis[j][m-1]==0 && grid[j][m-1]==1){
                dfs(j,m-1,vis,grid,n,m,delrow,delcol);
                // System.out.println(4);
            }
        }
        // System.out.println(count);
        int none=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                // System.out.print(vis[i][j]+" ");
                if(vis[i][j]==1){
                    none++;
                }
            }
            // System.out.println();
        }
        return count-none;
    }
}