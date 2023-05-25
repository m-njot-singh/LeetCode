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

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
// class Pair{
//     int first;
//     int second;
//     public Pair(int first,int second){
//         this.first=first;
//         this.second=second;
//     }
// }
class Solution {
    public static void dfs(int row,int col,int[][] vis,int[][]grid,ArrayList<Integer> vec,int n,int m,int brow,int bcol,int[] delrow,int[] delcol){
        vis[row][col]=1;
        // System.out.println(row);
        // System.out.println(col);
        // System.out.println(brow);
        // System.out.println(bcol);
       vec.add(row-brow);
       vec.add(col-bcol);
        for(int i=0;i<4;i++){
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
            
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                dfs(nrow,ncol,vis,grid,vec,n,m,brow,bcol,delrow,delcol);
            }
        }
        
    }

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        int[] delrow={1,0,-1,0};
        int [] delcol={0,-1,0,1};
        HashSet<ArrayList<Integer>> set=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]==1){
                    ArrayList<Integer> vec=new ArrayList<>();
                    dfs(i,j,vis,grid,vec,n,m,i,j,delrow,delcol);
                    // System.out.println(vec);
                    set.add(vec);
                }
            }
        }
        
        return set.size();
    }
}
