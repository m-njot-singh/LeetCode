class Solution {
    private void solve(int i,int n,int[]nums,int target,List<List<Integer>> ans,List<Integer> l){
            if(target==0){
                // List<Integer> temp=new ArrayList<>(l);
                // // Collections.sort(temp);
                    ans.add(new ArrayList<>(l));
                return ;
            }
            
       for(int j=i;j<nums.length;j++){
           if(j>i && nums[j]==nums[j-1])continue;
           if(nums[j]>target)break;
           l.add(nums[j]);
           solve(j+1,n,nums,target-nums[j],ans,l);
           l.remove(l.size()-1);
       }
    }
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        solve(0,nums.length,nums,target,ans,new ArrayList<>());
        
        return ans;
    }
}