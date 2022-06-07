class Solution {
//     static int min(int [] nums){
//         int min=nums[0];
//         for(int i=0;i<nums.length;i++){
//             if(nums[i]<min){
//                 min=nums[i];
//             }
//         }
//         return min;
//     }
    
//     static int minloc(int[]nums,int min){
//         int loc=0;
//         for(int i=0;i<nums.length;i++){
//             if(nums[i]==min){
//                 loc=i;
//             }
//         }
//         return loc;
//     }
    
//      static int max(int [] nums){
//         int max=nums[0];
//         for(int i=0;i<nums.length;i++){
//             if(nums[i]>max){
//                 max=nums[i];
//             }
//         }
//         return max;
//     }
    
//      static int maxloc(int[]nums,int max){
//         int loc=0;
//         for(int i=0;i<nums.length;i++){
//             if(nums[i]==max){
//                 loc=i;
//             }
//         }
//         return loc;
//     }
    
    
    public int maxProfit(int[] prices) {
        
        int minsofar=prices[0];
        int maxprofit=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<minsofar){
                minsofar=prices[i];
            }
            if((prices[i]-minsofar)>maxprofit){
                maxprofit=prices[i]-minsofar;
            }
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
//          int lsf = Integer.MAX_VALUE;
//         int op = 0;
//         int pist = 0;
        
//         for(int i = 0; i < prices.length; i++){
//             if(prices[i] < lsf){
//                 lsf = prices[i];
//             }
//             System.out.println(lsf);
//             pist = prices[i] - lsf;
//             if(op < pist){
//                 op = pist;
//             }
//         }
//         return op;
//         int min=min(prices);
//         int minloc=minloc(prices,min);
//         int max=max(prices);
//         int maxloc=maxloc(prices,max);
       
      
//         for(int i=0;i<prices.length;i++){
//             if(maxloc<minloc){
//                 prices[maxloc]=min;
//                 max=max(prices);
//                 maxloc=maxloc(prices,max);
//             }
//         }
        
         
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
//         int len=prices.length;
//         int [] ans=new int[len];
        
//         for(int i=0;i<prices.length-1;i++){
//             int b=prices[1]-prices[0];
//             for(int j=i+1;j<prices.length;j++){
//                 int a=prices[j]-prices[i];
//                 if(a>=b){
//                     ans[i]=a;
//                     b=a;
//                 }
//             }
//         }
//          int max=ans[0];
//         for(int k=0;k<len;k++){
           
//             if(ans[k]>max){
//                 max=ans[k];
//             }
//         }
        
        return maxprofit;
    }
}