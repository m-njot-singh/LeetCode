class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int[]pre= new int[n];
        int[] suf=new int[n];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(height[i]>max){
                max=height[i];
            }
            pre[i]=max;
        }
        
        
        max=Integer.MIN_VALUE;;
        for(int i=n-1;i>=0;i--){
            if(height[i]>max){
                max=height[i];
            }
            suf[i]=max;
        }
        
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=(Math.min(pre[i],suf[i])-height[i]);
        }
        
        return ans;
    }
}