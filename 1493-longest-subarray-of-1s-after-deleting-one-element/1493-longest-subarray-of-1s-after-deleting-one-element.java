class Solution {
    public int longestSubarray(int[] nums) {
        int len1=0;
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                len1=0;
                int len2=0;
                for(int j=0;j<nums.length;j++){
                    if(j==i)continue;
                    if(nums[j]==1){
                        len2++;
                        max=Math.max(max,len2);
                    }
                    else{
                        len2=0;
                    }
                }
            }
            else{
                len1++;
            }
        }
        if(len1>max){
            max=len1-1;
        }
        return max;
    }
}