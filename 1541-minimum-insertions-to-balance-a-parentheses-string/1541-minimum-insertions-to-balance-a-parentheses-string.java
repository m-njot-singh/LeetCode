class Solution {
    public int minInsertions(String s) {
        Stack<Character> st=new Stack<>();
        int count=0;
        for(int i=0;i<s.length();){
            if(s.charAt(i)=='('){
                st.push(s.charAt(i));
                    i++;
            }
            else{
                if(st.isEmpty()){
                    if(i+1<s.length()&& s.charAt(i+1)==')'){
                        count++;
                        i+=2;
                    }
                    else{
                        count+=2;
                        i++;
                    }
                }
                else{
                    if(i+1<s.length() && s.charAt(i+1)==')'){
                        i+=2;
                    }
                    else{
                        count++;
                        i++;
                    }
                    st.pop();
                }
            }
            
        }
        while(!st.isEmpty()){
            st.pop();
            count+=2;
        }
        return count;
    }
}