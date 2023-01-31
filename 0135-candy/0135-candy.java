class Solution {
    public int candy(int[] arr) {
        int[] l=new int[arr.length];
        int[] r=new int[arr.length];
        Arrays.fill(l, 1);
        Arrays.fill(r, 1);
        int count=0;
        int j=0;
        for(int i=0;i<arr.length-1;i++){
            j=i+1;
            if(arr[i]<arr[j]){
                l[j]=l[i]+1;
                System.out.println(l[j]);
            }
        }
        j=0;
        for(int i=arr.length-1;i>0;i--){
            j=i-1;
            if(arr[j]>arr[i]){
                r[j]=r[i]+1;
                System.out.println(r[j]);
            }
        }
        
        for(int i=0;i<arr.length;i++){
            System.out.println(l[i] +" "+r[i]);
            count+=Math.max(l[i],r[i]);
            System.out.println(count);
        }
        return count;
    }
}