class Solution {
    public static int help(int[] weights,int mid,int days){
        int count=1;
        int temp=0;
        for(int i=0;i<weights.length;i++){
            if(weights[i]+temp>mid){
                count++;
                temp=weights[i];
            }
            else{
                temp+=weights[i];
            }
        }
        return count;
    }
    public int shipWithinDays(int[] weights, int days) {
        int i=Integer.MIN_VALUE;
        int j=0;
        for(int q=0;q<weights.length;q++){
            i=Math.max(i,weights[q]);
            j+=weights[q];
        }
        while(i<=j){
            int mid=(i+j)/2;
            int temp=help(weights,mid,days);
            if(temp<=days){
                j=mid-1;
            }
            else{
                i=mid+1;
            }
        }
        
        return i;
    }
}