class Solution {
    public static int rec(int i,int j,int flag,int[] nums){
        if(i>j)return 0;
        int ans=0,start=0,end=0;
        if(flag==0){
            start=nums[i]+rec(i+1,j,1,nums);
            end=nums[j]+rec(i,j-1,1,nums);
            ans=Math.max(start,end);
        }
        else{
            start=-nums[i]+rec(i+1,j,0,nums);
            end=-nums[j]+rec(i,j-1,0,nums);
            ans=Math.min(start,end);
        }
        return ans;
    }
    public boolean PredictTheWinner(int[] nums) {
        return rec(0,nums.length-1,0,nums)>=0;
    }
}