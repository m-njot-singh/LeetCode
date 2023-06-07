class Solution {
    public int maxProfit(int[] prices) {
        int[] ahead=new int[2];
        int[] curr=new int[2];
        
        for(int i=0;i<2;i++)ahead[i]=0;
        for(int ind=prices.length-1;ind>=0;ind--){
            for(int buy=0;buy<2;buy++){
                
                int profit=0;
                if(buy==1){
                    profit=Math.max((-prices[ind]+ahead[0]),0+ahead[1]);
                }
                else{
                    profit=Math.max((prices[ind]+ahead[1]),0+ahead[0]);
                }
                curr[buy]=profit;
            }
            ahead=(int[])(curr.clone());
        }
        
        
        return ahead[1];
        
    }
}