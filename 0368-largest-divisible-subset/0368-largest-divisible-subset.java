class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int[] dp=new int[n];
        int[] hash=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=1;
            hash[i]=1;
        }
        int max=-1;
        int lastIndex=-1;
        for(int i=0;i<n;i++){
            hash[i]=i;
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0 && dp[j]+1>dp[i]){
                    dp[i]=1+dp[j];
                    hash[i]=j;
                }
            }
            if(dp[i]>max){
                max=dp[i];
                lastIndex=i;
            }
        }
        
        List<Integer> ans=new ArrayList<>();
        ans.add(nums[lastIndex]);
        while(hash[lastIndex]!=lastIndex){
            lastIndex=hash[lastIndex];
            ans.add(nums[lastIndex]);
        }
        Collections.reverse(ans);
        return ans;
    }
}