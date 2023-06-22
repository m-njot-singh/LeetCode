class Solution {
    
    public String longestPalindrome(String s) {
        int n=s.length();
        String ans=""+s.charAt(0);
        int start=0;
        int end=0;
        boolean[][] dp=new boolean[n][n];
        for(int gap=0;gap<n;gap++){
            for(int i=0,j=gap;j<n;i++,j++){
                if(gap==0){
                    dp[i][j]=true;
                    if((j-i+1)> (start-end+1)){
                       start=i;
                        end=j;
                    }
                }
                else if(gap==1){
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j]=true;
                        if((j-i+1)> (start-end+1)){
                       start=i;
                        end=j;
                    }
                    }
                    else{
                        dp[i][j]=false;
                    }
                }
                else{
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==true){
                        dp[i][j]=true;
                        if((j-i+1)> (start-end+1)){
                       start=i;
                        end=j;
                    }
                    }
                    else{
                        dp[i][j]=false;
                    }
                }
            }
        }
        return s.substring(start,end+1);
        
    }
}