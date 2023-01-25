class Solution {
    public int maxScore(int[] arr, int k) {
        int start=0;
        int end=0;
        int sum=0;
        int mn=Integer.MAX_VALUE;
        int totalsum=0;
        int a=arr.length-k;
        for(int i=0;i<arr.length;i++){
            totalsum+=arr[i];
        }
        // System.out.println(totalsum);
        if(a==0)return totalsum;
        while(end<arr.length){
            sum+=arr[end];
            if(end-start+1<a){
                
                // System.out.println(sum);
                end++;
            }
            else if(end-start+1==a){
                mn=Math.min(mn,sum); 
                sum-=arr[start];
                start++;
                end++;
            }
            
        }
        return totalsum-mn;
    }
}