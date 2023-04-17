class Solution {
    public int findPeakElement(int[] arr) {
        // if(arr.length==2){
        //     if(arr[0]>arr[1]){
        //         return 0;
        //     }
        //     return 1;
        // }
        int idx=0;
        for(int i=1;i<=arr.length-2;i++){
            if(arr[i]>arr[i-1] && arr[i]>arr[i+1]){
                // int count=1;
                // int j=i;
                // while(j>0 && arr[j]>arr[j-1]){
                //         count++;
                //         j--;
                // }
                idx=i;
                // while(i<arr.length-1 && arr[i]>arr[i+1]){
                //         count++;
                //         i++;
                // }
            }
            // else{
            //     i++;
            // }
            
        }
        if(idx==0){
            if(arr[0]>arr[arr.length-1]){
                return 0;
            }
            return arr.length-1;
        }
        
        return idx;
    }
}