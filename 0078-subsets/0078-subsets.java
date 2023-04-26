class Solution {
    public static void subset(int i,int n,int[]nums,List<List<Integer>> ans,List<Integer> l){
        if(i==n){
            ans.add(new ArrayList<>(l));
            return ;
        }
        l.add(nums[i]);
        subset(i+1,n,nums,ans,l);
        l.remove(l.size()-1);
        subset(i+1,n,nums,ans,l);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        subset(0,nums.length,nums,ans,new ArrayList<>());
        return ans;
    }
}