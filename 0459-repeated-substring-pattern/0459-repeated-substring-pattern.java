class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len=s.length();
        for(int i=0;i<len/2;i++){
            String temp=s.substring(0,i+1);
            // System.out.println(temp);
            StringBuilder ans=new StringBuilder();
            if(len%temp.length()==0){
                int count=len/temp.length();
                while(count>0){
                    ans.append(temp);
                    count--;
                }
            }
            if(ans.toString().equals(s))return true;
        }
        
        return false;
    }
}