//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public static void dfs(int[][] vis,char[][] a,int row,int col,int []downcol,int [] downrow){
         vis[row][col]=1;
         int n=a.length;
         int m=a[0].length;
         
         for(int i=0;i<4;i++){
             int nrow=row+downrow[i];
             int ncol=col+downcol[i];
             if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && a[nrow][ncol]=='O'){
                 dfs(vis,a,nrow,ncol,downcol,downrow);
             }
         }
    }
    static char[][] fill(int n, int m, char a[][])
    {
        // code here
        int[][] vis=new int[n][m];
        int downrow[]={1,0,-1,0};
        int downcol[]={0,-1,0,1};
        
        for(int j=0;j<m;j++){
            if(vis[0][j]==0 && a[0][j]=='O'){
                dfs(vis,a,0,j,downcol,downrow);
            }
            if(vis[n-1][j]==0 && a[n-1][j]=='O'){
                dfs(vis,a,n-1,j,downcol,downrow);
            }
        }
        for(int i=0;i<n;i++){
            if(vis[i][0]==0 && a[i][0]=='O'){
                dfs(vis,a,i,0,downcol,downrow);
            }
            if(vis[i][m-1]==0 && a[i][m-1]=='O'){
                dfs(vis,a,i,m-1,downcol,downrow);
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && a[i][j]=='O'){
                    a[i][j]='X';
                }
            }
        }
        return a;
    }
}