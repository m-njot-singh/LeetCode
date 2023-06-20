class Solution {
    public int[] getAverages(int[] nums, int k) {
        int[] ans=new int[nums.length];
            Arrays.fill(ans,-1);
        if(k>nums.length)return ans;
        int ind=k;
        int target=(k*2)+1;
        int i=0;
        int j=0;
        long sum=0;
        
        while(j<nums.length){
            sum+=nums[j];
            if(j-i+1<target){
                j++;
            }
            else if(j-i+1==target){
                ans[ind]=(int)(sum/(j-i+1));
                ind++;
                sum-=nums[i];
                i++;
                j++;
            }
            
        }
        
        return ans;
    }
}