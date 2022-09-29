class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
//         List<Integer> list=new ArrayList<Integer>();
//         // int[] a=new int[arr.length];
//         // for(int i=0;i<arr.length;i++){
//         //     a[i]=Math.abs(arr[i]-x);
//         // }
//         int i=0;
//         int j=arr.length-1;
//         while(j>=k){
//              if(Math.abs(arr[i]-x)>Math.abs(arr[j]-x))i++;
//         else j--;
//         }
        
//         for(int q=i;q<=j;q++){
//             list.add(arr[q]);
//         }
//         return list;
        
        
        int start=0;
int end=arr.length-1;
    
while(end-start>=k)
{
    if(Math.abs(arr[start]-x)>Math.abs(arr[end]-x))
    {
        start++;
    }
    else
    {
        end--;
    }
}
    List<Integer> ans=new ArrayList<>();
    for(int i=start;i<=end;i++)
    {
        ans.add(arr[i]);
    }
    return ans;
        
        
        
        
    }
}