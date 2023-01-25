class Solution {
    // public static int max(List<Integer> l,int w){
    //     // System.out.println(l);
    //     int max=Integer.MIN_VALUE;
    //     // System.out.println(max);
    //          for(int i=w;i<l.size();i++){
    //         // System.out.println(i);
    //         if(l.get(i)>max){
    //             max=l.get(i);
    //             // System.out.println(l.get(i));
    //         }
    //     }
    //     // System.out.println(max);
    //     return max;
    // }
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         List<Integer> l=new ArrayList<>();
//         List<Integer> ans=new ArrayList<>();
       
//         int i=0;
//         int j=0;
//         while(j<nums.length){
//             l.add(nums[j]);
            
//             if(j-i+1<k){
//                 j++;
//             }
//             else if(j-i+1==k){
//                 // System.out.println(l);
//                 int max=max(l,i);
//                 // System.out.println();
//                 ans.add(max);
//                 j++;
//                 i++;
//             }
//         } 
//          int [] arr=new int[ans.size()];
//          for(int q=0;q<ans.size();q++){
//              arr[q]=ans.get(q);
//          }
//         return arr;
    
    
    
    
    
    
    
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k==1)return nums;
        List<Integer> l=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
       
        int i=0;
        int j=0;
        while(j<nums.length){
            while(l.size()>0 && l.get(l.size()-1)<nums[j]){
                l.remove(l.size()-1);
            }
            l.add(nums[j]);
            
            if(j-i+1<k){
                j++;
            }
            else if(j-i+1==k){
                // System.out.println(l);
                // System.out.println();
                ans.add(l.get(0));
                if(l.get(0)==nums[i]){
                    l.remove(0);
                }
                 
                j++;
                i++;
            }
        } 
         int [] arr=new int[ans.size()];
         for(int q=0;q<ans.size();q++){
             arr[q]=ans.get(q);
         }
        return arr;
    }
}