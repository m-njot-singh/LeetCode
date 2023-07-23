class Solution {
    public long maxArrayValue(int[] nums) {
        if(nums.length==1)return (long)nums[0];
        if(nums.length==2){
            return nums[0]<=nums[1]?(long)(nums[0]+nums[1]):(long)(Math.max(nums[0],nums[1]));
        }
        int n=nums.length-1;
        long last=(long)nums[n];
        long ans=0;
        for(int i=n-1;i>=0;i--){
            long val=(long)nums[i];
            if(val<=last){
                
                last=last+val;
                if(last>ans){
                    ans=last;
                }
            }
            else{
                if(last>ans){
                    ans=last;
                }
                last=val;
            }
        }
        return last;
    }
}