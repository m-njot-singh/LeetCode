class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0;
        int j=0;
        int count=0;
        int k=0;
        while(j<nums.length){
            if(nums[i]==nums[j]){
                count++;
                if(count>2){
                    nums[j]=Integer.MAX_VALUE;
                    // count=0;
                    j++;
                    // i=j;
                }
                else{
                   j++; 
                }
                
            }
            else{
                i=j;
                count=0;
            }
        }
        Arrays.sort(nums);
        for(int q=0;q<nums.length;q++){
            if(nums[q]==Integer.MAX_VALUE){
                break;
            }
            k++;
        }
        return k;
    }
}