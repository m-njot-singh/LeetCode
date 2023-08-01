class Solution {
    public static void dfs(int i,int[] arr,int k,List<List<Integer>> ans,List<Integer> l){
        if(i==arr.length){
             if(l.size()==k){
            ans.add(new ArrayList<Integer>(l));
        }
            return;
        }
       
        l.add(arr[i]);
        dfs(i+1,arr,k,ans,l);
        l.remove(l.size()-1);
        dfs(i+1,arr,k,ans,l);
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)arr[i]=i+1;
        dfs(0,arr,k,ans,new ArrayList<Integer>());
        return ans;
    }
}