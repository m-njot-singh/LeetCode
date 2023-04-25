class Solution {
    public static void combination(int i,int n,int[] nums,int target,List<List<Integer>> l,List<Integer> ans){
        if(i==n){
            if(target==0){
                l.add(new ArrayList<>(ans));
            }
            return;
        }
        if(nums[i]<=target){
            ans.add(nums[i]);
            combination(i,n,nums,target-nums[i],l,ans);
            ans.remove(ans.size()-1);
        }
        combination(i+1,n,nums,target,l,ans);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> l=new ArrayList<>();
        combination(0,nums.length,nums,target,l,new ArrayList<>());
        return l;
    }
}