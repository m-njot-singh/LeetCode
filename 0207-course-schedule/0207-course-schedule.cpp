class Solution {
public:
//     bool dfs(int src,vector<bool> &vis,vector<bool> &stack,vector<int> adj[])
//     {
//         vis[src]=1;
//         stack[src]=1;
//         for(auto x:adj[src])
//         {
//             if(!vis[x])
//             {
//                 if(dfs(x,vis,stack,adj))
//                 {
//                     return true;
//                 }
//             }
//             else
//             {
//                 if(stack[x])
//                 {
//                     return true;
//                 }
//             }
//         }
//         stack[src]=0;
//         return false;
//     }
//     bool canFinish(int V, vector<vector<int>>& prerequisites) {
//         vector<int> adj[V];
//         int n=prerequisites.size();
//         int m=prerequisites[0].size();
//         for(int i=0;i<n;i++)
//         {
//             adj[prerequisites[i][0]].push_back(prerequisites[i][1]);
//         }
//         vector<bool> vis(V,0);
//         vector<bool> stack(V,0);
        
        
//         for(int i=0;i<V;i++)
//         {
//             if(!vis[i])
//             {
//                 bool ans =dfs(i,vis,stack,adj);
//                 if(ans)
//                 {
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }
    bool dfs(int src,vector<int> adj[],vector<bool> &vis,vector<bool> &stack)
    {
        vis[src]=1;
        stack[src]=1;
        
        for(auto x : adj[src])
        {
            if(!vis[x])
            {
                if(dfs(x,adj,vis,stack))
                {
                    return true;
                }
            }
            else
            {
                if(stack[x])
                {
                    return true;
                }
            }
        }
        stack[src]=0;
        return false;
    }
    bool canFinish(int n, vector<vector<int>>& pre) {
        vector<int> adj[n];
        
        
        for(int i=0;i<pre.size();i++)
        {
            adj[pre[i][0]].push_back(pre[i][1]);
        }
        vector<bool> vis(n,0);
        vector<bool> stack(n,0);
        for(int i=0;i<n;i++)
        {
            if(!vis[i])
            {
                bool ans=dfs(i,adj,vis,stack);
                if(ans)
                {
                    return false;;
                }
            }
        }
        return true;
    }
};