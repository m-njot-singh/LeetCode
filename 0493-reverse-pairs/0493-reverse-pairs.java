class Solution {
     private static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(); // temporary array
        int left = low;      // starting index of left half of arr
        int right = mid + 1;   // starting index of right half of arr

        //storing elements in the temporary array in a sorted manner//

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        // if elements on the left half are still left //

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        //  if elements on the right half are still left //
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // transfering all elements from temporary to arr //
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }
    
    public static int countPairs(int[] arr,int low,int mid,int high){
        int count=0;
        // int left=low;
        int right=mid+1;
        for(int i=low;i<=mid;i++){
            // long a=arr[i];
            
            while(right<=high){
               long temp=arr[right];
                long b=2*temp;
                if(arr[i]>b)right++;
                else break;
            }
            count+=(right-(mid+1));
        }
        return count;
        
    }

    public static int mergeSort(int[] arr, int low, int high) {
        int count=0;
        if (low >= high) return count;
        int mid = (low + high) / 2 ;
        count+=mergeSort(arr, low, mid);  // left half
        count+=mergeSort(arr, mid + 1, high); // right half
        count+=countPairs(arr,low,mid,high); // count Pairs
        merge(arr, low, mid, high);  // merging sorted halves
        
        return count;
    }
    public int reversePairs(int[] nums) {
        int count=0;
        int high=nums.length-1;
        count=mergeSort(nums,0,high);
        return count;
    }
}