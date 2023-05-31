//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] adj = new int[m][3];

            for (int i = 0; i < m; i++) {

                for (int j = 0; j < 3; j++) {
                    adj[i][j] = sc.nextInt();
                }
            }

            int dist = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.findCity(n, m, adj, dist);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
      int findCity(int n, int m, int[][] edges,int distanceThreshold)
      {
          //code here
          int dis[][]=new int[n][n];
          for(int i=0;i<n;i++){
              for(int j=0;j<n;j++){
                  dis[i][j]=(int)1e9;
              }
          }
          
          for(int i=0;i<m;i++){
              int u=edges[i][0];
              int v=edges[i][1];
              int w=edges[i][2];
              
              dis[u][v]=w;
              dis[v][u]=w;
          }
          
          for(int i=0;i<n;i++){
              dis[i][i]=0;
          }
          
          for(int k=0;k<n;k++){
              for(int i=0;i<n;i++){
                  for(int j=0;j<n;j++){
                      dis[i][j]=Math.min(dis[i][j],dis[i][k]+dis[k][j]);
                  }
              }
          }
          
          
          int ans=Integer.MIN_VALUE;
          int city=Integer.MAX_VALUE;
          
          for(int i=0;i<n;i++){
              int count=0;
              for(int j=0;j<n;j++){
                  if(dis[i][j]<=distanceThreshold){
                      count++;
                  }
              }
              if(count<city){
                  city=count;
                  ans=i;
              }
              if(count==city){
                  ans=Math.max(ans,i);
              }
          }
          return ans;
          
      }
}
