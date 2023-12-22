class Solution {
    public int maxScore(String s) {
       int ones=0;
        int zeros=0;
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1')ones++;
        }
        int maxscore=Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                zeros++;
                maxscore=Math.max(maxscore,zeros+ones);
            }else{
                ones=ones-1;
                maxscore=Math.max(maxscore,zeros+ones);
                if(ones==0)zeros=zeros-1;
            }
        }
        if(zeros==s.length()){
            maxscore=maxscore-1;
        }
        return maxscore;
    }
}