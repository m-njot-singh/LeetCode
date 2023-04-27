//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static void solve(int row,int col,int[][] m, int n,ArrayList<String> ans, String s,int [][] vis){
        // if(row>m.length || col>m[0].length || row<0 || col<0 || m[row][col]!=1)return;
        if(row==n-1 && col==n-1){
            ans.add(s);
            return;
        }
        
        if(row+1<n && vis[row+1][col]==0 && m[row+1][col]==1){
            vis[row][col]=1;
            solve(row+1,col,m,n,ans,s+'D',vis);
            vis[row][col]=0;
        }
        
        if(col+1<n && vis[row][col+1]==0 && m[row][col+1]==1){
            vis[row][col]=1;
            solve(row,col+1,m,n,ans,s+'R',vis);
            vis[row][col]=0;
        }
        
        if(row-1>=0 && vis[row-1][col]==0 && m[row-1][col]==1){
            vis[row][col]=1;
            solve(row-1,col,m,n,ans,s+'U',vis);
            vis[row][col]=0;
        }
        
        if(col-1>=0 && vis[row][col-1]==0 && m[row][col-1]==1){
            vis[row][col]=1;
            solve(row,col-1,m,n,ans,s+'L',vis);
            vis[row][col]=0;
        }
        
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        int[][] vis=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                vis[i][j]=0;
            }
        }
        ArrayList<String> ans=new ArrayList<>();
        String s="";
        if(m[0][0]==1){
             solve(0,0,m,n,ans,s,vis);
        }
       
        // Collections.sort(ans);
        return ans;
    }
}