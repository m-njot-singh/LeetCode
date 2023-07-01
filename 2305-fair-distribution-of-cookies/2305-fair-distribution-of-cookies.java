class Solution {
    public static int dfs(int i,int n,int[] cookies,int [] arr){
        int ans=Integer.MAX_VALUE;
        if(i==n){
            int max=Integer.MIN_VALUE;
            for(int q:arr){
                max=Math.max(max,q);
            }
            return max;
        }
        for(int j=0;j<arr.length;j++){
            arr[j]+=cookies[i];
            ans=Math.min(ans,dfs(i+1,n,cookies,arr)) ;
            arr[j]-=cookies[i];
        }
        return ans;
    }
    public int distributeCookies(int[] cookies, int k) {
        int [] arr=new int[k];
        return dfs(0,cookies.length,cookies,arr);
    }
}