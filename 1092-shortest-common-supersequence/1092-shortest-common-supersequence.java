class Solution {
    public String shortestCommonSupersequence(String s, String a) {
        int n=s.length();
        int m=a.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++)dp[i][0]=0;
        for(int j=0;j<=m;j++)dp[0][j]=0;
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                
                if(s.charAt(i-1)==a.charAt(j-1)) dp[i][j]= 1+dp[i-1][j-1];
                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        // for(int i=0;i<=n;i++){
        //     for(int j=0;j<=m;j++){
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        StringBuilder ans=new StringBuilder();
        int i=n;
        int j=m;
        while(i>0 && j>0){
            if(s.charAt(i-1)==a.charAt(j-1)){
                ans.append(s.charAt(i-1));
                i--;j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                ans.append(s.charAt(i-1));
                i--;
            }
            else{
                ans.append(a.charAt(j-1));
                j--;
            }
            
        }
        
        while(i>0){
            ans.append(s.charAt(i-1));
            i--;
        }
        while(j>0){
            ans.append(a.charAt(j-1));
            j--;
        }
            
        ans.reverse();
        
        return ans.toString();
    }
}