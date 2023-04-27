class Solution {
    public static void solve(boolean[] b,int[] nums,List<List<Integer>> ans,List<Integer> l){
        if(l.size()==nums.length){
            ans.add(new ArrayList<>(l));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!b[i]){
                b[i]=true;
                l.add(nums[i]);
                solve(b,nums,ans,l);
                l.remove(l.size()-1);
                b[i]=false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        boolean[] b=new boolean[nums.length];
        
        solve(b,nums,ans,new ArrayList<Integer>());
        return ans;
    }
}