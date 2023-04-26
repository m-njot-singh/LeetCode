class Solution {
    public static void subset(int i,int n,int[] nums,List<List<Integer>> ans,List<Integer> l){
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
        subset(i+1,n,nums,ans,l);
        l.remove(l.size()-1);
        subset(i+1,n,nums,ans,l);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        subset(0,nums.length,nums,ans,new ArrayList<>());
        return ans;
    }
}