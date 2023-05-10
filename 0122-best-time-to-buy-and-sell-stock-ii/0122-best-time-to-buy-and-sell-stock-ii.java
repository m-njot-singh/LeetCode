class Solution {
    public int maxProfit(int[] prices) {
        int i=0;
        int j=0;
        int profit=0;
        while(i<prices.length-1 && j<prices.length-1){
            while(j<prices.length-1){
                if(prices[j]>=prices[j+1]){
                     j++;
                }
               else{
                   break;
               }
            }
            i=j;
            while(i<prices.length-1 ){
                if(prices[i]<=prices[i+1]){
                    i++;
                }
                else{
                    break;
                }
            }
            profit+=prices[i]-prices[j];
            // System.out.println("profit="+profit+" "+"i="+i+"j="+j);
            j=i;
            // System.out.println(j+" "+i);
        }
        return profit;
    }
}