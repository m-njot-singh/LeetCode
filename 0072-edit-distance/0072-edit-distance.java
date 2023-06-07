class Solution {
    public int minDistance(String s, String a) {
        int n=s.length();
        int m=a.length();
        int[] prev=new int[m+1];
        int[] curr=new int[m+1];
        for(int j=0;j<=m;j++)prev[j]=j;
        
        for(int i=1;i<=n;i++){
            curr[0]=i;
            for(int j=1;j<=m;j++){
                
                if(s.charAt(i-1)==a.charAt(j-1)) curr[j]=0+prev[j-1];
                else curr[j]=1+Math.min(prev[j],Math.min(curr[j-1],prev[j-1]));
                
            }
            prev=(int[])(curr.clone());
        }
        return prev[m];
    }
}