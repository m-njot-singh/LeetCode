class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1)return s;
        String ans="";
       for(int r=0;r<numRows;r++){
            int inr=2*(numRows-1);
                for(int i=r;i<s.length();i+=inr){
                    ans+=s.charAt(i);
                    if(r>0 && r<numRows-1 && i+inr-2*r<s.length()){
                        ans+=s.charAt(i+inr-2*r);
                    }
                }
            
        }
        return ans;
    }
}