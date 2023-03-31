class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0 && nums2.length == 0){
            return 0;
        }
        
       else if(nums1.length == 0 && nums2.length != 0){
            // System.out.println("yes");
            int n = nums2.length;
            return nums2[(n - 1) / 2] * 0.5 + nums2[n / 2]*0.5 ;
        }
        
        else if(nums2.length == 0 && nums1.length != 0){
            int n = nums1.length;
            return nums1[(n - 1) / 2] * 0.5 + nums1[n / 2] * 0.5;
        }
        else{
            int size1=nums1.length;
        int size2=nums2.length;
        int a=0;
        int b=0;
        List<Double> l=new ArrayList<>();
       
        
        
        for(int i=0;i<(size1+size2);i++){
            if(nums1[a]<nums2[b]){
                l.add((double)nums1[a]);
                nums1[a]=Integer.MAX_VALUE;
                if(a<size1-1){
                    // System.out.println(a);
                    a++;
                }
                
            }
            else{
                l.add((double)nums2[b]);
                nums2[b]=Integer.MAX_VALUE;
                if(b<size2-1){
                    // System.out.println(b);
                    b++;
                }
                
            }
        }
        
        // System.out.println(l);
        if(l.size()%2!=0){
            return l.get((l.size()-1)/2);
        }
        int floor=(int)Math.floor((l.size()-1)/2);
        int roof=(int)Math.ceil((float)(l.size()-1)/2);
        // System.out.println(floor);
        //  System.out.println(Math.ceil((float)(l.size()-1)/2));
        return ((l.get(floor)+l.get(roof))/2);
        }
        
    }
}