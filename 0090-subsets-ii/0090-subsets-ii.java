class Solution {
    public static void dfs(int i,int n,List<Integer> l,List<List<Integer>> ans,int[] nums){
        if(i==n){
            List<Integer> temp=new ArrayList<>(l);
            Collections.sort(temp);
            if(ans.isEmpty()){
                ans.add(temp);
            }
            if(!ans.contains(temp)){
                ans.add(new ArrayList<>(temp));
            }
            
            return ;
        }
        l.add(nums[i]);
        dfs(i+1,n,l,ans,nums);
        l.remove(l.size()-1);
        dfs(i+1,n,l,ans,nums);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        dfs(0,nums.length,new ArrayList<>(),ans,nums);
        return ans;
    }
}