class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair<Character,Integer>>st=new Stack<>();
        int count=1;
        String ans="";
        for(int i=0;i<s.length();i++){
            if(!st.isEmpty() && st.peek().getKey()==s.charAt(i)){
                    st.push(new Pair(s.charAt(i),st.peek().getValue()+1));
                    // System.out.println(st.peek().getKey());
                    if(st.peek().getValue()==k){
                    int a=k;
                    while(a-->0){
                        st.pop();
                    }
                }
                }
            else{
                st.push(new Pair(s.charAt(i),1));
                // System.out.println(st.peek().getKey());
            }
        }
        // System.out.println(st.size());
        while(!st.isEmpty()){
            ans+=st.peek().getKey();
            st.pop();
        }
        StringBuilder input1 = new StringBuilder();
        input1.append(ans);
        input1.reverse();
        return input1.toString();
    }
}