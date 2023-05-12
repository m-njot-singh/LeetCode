class Solution {
    public static void dfs(int i,int[]nums,List<Integer> l,List<List<Integer>> ans,boolean[] q){
        if(l.size()==nums.length){
            if(!ans.contains(l)){
                ans.add(new ArrayList<>(l));
            }
            
            return;
        }
        for(int idx=0;idx<nums.length;idx++){
            if(!q[idx]){
                q[idx]=true;
                l.add(nums[idx]);
                dfs(idx,nums,l,ans,q);
                l.remove(l.size()-1);
                q[idx]=false;
            }
        }
        
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        boolean[] q=new boolean[nums.length];
        dfs(0,nums,new ArrayList<>(),ans,q);
        return ans;
    }
}