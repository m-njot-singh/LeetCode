class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

class Solution {
    
    public static boolean isValid(int newr,int newc,int n){
        return newr>=0 && newr<n && newc>=0 && newc<n ;
    }
    public int largestIsland(int[][] grid) {
        
        int n=grid.length;
        
        DisjointSet ds=new DisjointSet(n*n);
        
        //STEP_1
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0)continue;
                
                 int[] dr={1,0,-1,0};
                 int[] dc={0,-1,0,1};
                for(int ind=0;ind<4;ind++){
                    int newr=i+dr[ind];
                    int newc=j+dc[ind];
                    
                    if(isValid(newr,newc,n) && grid[newr][newc]==1){
                        int nodeNo=i*n+j;
                        int adjNodeNo=newr*n+newc;
                        ds.unionBySize(nodeNo,adjNodeNo);
                    }
                }
            }
        }
        
        //STEP_2
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    continue;
                }
                
                 int[] dr={1,0,-1,0};
                 int[] dc={0,-1,0,1};
                    
                Set<Integer> set=new HashSet<>();
                for(int ind=0;ind<4;ind++){
                    int newr=i+dr[ind];
                    int newc=j+dc[ind];
                    
                    if(isValid(newr,newc,n)){
                       if(grid[newr][newc]==1){
                           set.add(ds.findUPar(newr*n+newc));
                       }
                    }
                }
                    
                    int size=0;
                    for(int a:set){
                        size+= ds.size.get(a);
                    }
                    ans=Math.max(ans,size+1);
            }
           
        } 
        for(int q=0;q<n*n;q++){
                ans=Math.max(ans,ds.size.get(ds.findUPar(q)));
            }
        return ans;
    }
}