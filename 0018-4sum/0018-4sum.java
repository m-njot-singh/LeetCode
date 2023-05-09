class Solution {
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> ans=new ArrayList<>();
        if(nums==null)return ans;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            // while(i>0 && i<nums.length && nums[i]==nums[i-1])i++;
            for(int j=i+1;j<nums.length;j++){
                // while(j<nums.length && nums[j]==nums[j-1])j++;
                int left=j+1;
                int right=nums.length-1;
                long sum=nums[i]+nums[j];
                while(left<right){
                    if(nums[left]+nums[right]<target-sum)left++;
                    else if(nums[left]+nums[right]>target-sum)right--;
                    else{
                        List<Integer> l=new ArrayList<>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[left]);
                        l.add(nums[right]);
                        ans.add(l);
                        while(left<right && nums[left]==l.get(2))left++;
                        while(left<right && nums[right]==l.get(3))right--;
                    }
                    
                }
                while(j+1<nums.length && nums[j+1]==nums[j])j++;
            }
            while(i+1<nums.length && nums[i+1]==nums[i])i++;
        }
        return ans;
    }
}