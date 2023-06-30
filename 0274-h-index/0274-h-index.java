class Solution {
    public int hIndex(int[] citations) {
        int n=citations.length;
        int[] bucket=new int[n+1];
        for(int i=0;i<n;i++){
            if(citations[i]>n){
                bucket[n]++;
            }
            else{
                bucket[citations[i]]++;
            }
        }
        int ans=0;
        int count=0;
        for(int i=n;i>=0;i--){
            if(bucket[i]+count>=i){
                ans=Math.max(ans,i);
            }
            count+=bucket[i];
            
        }
        return ans;
    }
}