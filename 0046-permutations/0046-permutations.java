class Solution {
    private void solve(int i,int[] nums,List<List<Integer>> ans){
        if(i==nums.length){
            List<Integer> l=new ArrayList<>();
            for(int q=0;q<nums.length;q++){
                l.add(nums[q]);
            }
            ans.add(new ArrayList<>(l));
            return ;
        }
        for(int j=i;j<nums.length;j++){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            solve(i+1,nums,ans);
            int q=nums[i];
            nums[i]=nums[j];
            nums[j]=q;
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        solve(0,nums,ans);
        return ans;
    }
}