class Solution {
    public boolean isValid(String s) {
        Stack st=new Stack<Integer>();
        int n=s.length();
        if(s.charAt(0)=='}' || s.charAt(0)==']' || s.charAt(0)==')'){
            return false;
        }
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='[' || s.charAt(i)== '{'|| s.charAt(i)== '('){
                st.push(s.charAt(i));
            }
            else{
                
               
                if(st.empty()){
                    return false;
                } 
                char c=(char)st.peek();
                 if((s.charAt(i)=='}') && (c=='{')){
                    st.pop();
                }
                else if((s.charAt(i)==']') && (c=='[')){
                     st.pop();
                }
                else if((s.charAt(i)==')') && (c=='(')){
                     st.pop();
                }
                else{
                    return false;
                }
            }
        }
        if(st.empty()){
            return true;
        }
        
        return false;
    }
}