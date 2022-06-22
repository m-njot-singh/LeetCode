class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
               
                if(nums1[i]==nums2[j]){
                    int max1=nums1[i];
                    int loc=j;
                     // if(j==nums2.length-1){
                     //     ans[i]=-1;
                     //     break;
                     // }
                    for(int q=j+1;q<nums2.length;q++){
                        if(max1<nums2[q]){
                            max1=nums2[q];
                            break;
                        }
                    }
                    if(max1==nums1[i]){
                        max1=-1;
                    }
                    
                    ans[i]=max1;
                }
                // break;
            }
        }
        
        return ans;
    }
}