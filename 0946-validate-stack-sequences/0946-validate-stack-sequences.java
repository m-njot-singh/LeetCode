class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
         Stack<Integer> st=new Stack<>();
        int pop=0;
        int i=0;
        while(i<pushed.length){ 
            st.push(pushed[i]);
            while(!st.isEmpty()&& st.peek()==popped[pop]){
                // System.out.println(st.peek());
                st.pop();
                pop++;
            }
             i++;
        }
        if(st.isEmpty())return true;
        return false;
    }
}