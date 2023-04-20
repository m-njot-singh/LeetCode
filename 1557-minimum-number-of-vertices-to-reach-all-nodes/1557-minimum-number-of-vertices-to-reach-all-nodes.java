class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> l=new ArrayList<>();
        int[] ans=new int[n];
        int[] vis=new int[edges.size()];
        int i=0;
        for(List<Integer> a:edges){
            ans[a.get(1)]+=1;
            i++;
        }
        for(int j=0;j<ans.length;j++){
            if(ans[j]==0)l.add(j);
        }
        
        return l;
    }
}