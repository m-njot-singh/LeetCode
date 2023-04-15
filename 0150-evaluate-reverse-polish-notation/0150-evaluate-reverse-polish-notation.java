class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s=new Stack<>();
        String st="+-*/";
        for(String q:tokens){
            if(st.contains(q) && !s.isEmpty()){
                int val1=s.peek();
                s.pop();
                int val2=s.peek();
                s.pop();
                if(q.equals("+")){
                    int ans=val2+val1;
                    System.out.println(ans);
                    s.push(ans);
                }
                else if(q.equals("-")){
                    int ans=val2-val1;
                    s.push(ans);
                }
                else if(q.equals("*")){
                    int ans=val2*val1;
                     System.out.println(ans);
                    s.push(ans);
                }
                else if(q.equals("/")){
                    int ans=val2/val1;
                    s.push(ans);
                }
            }
            else{
                s.push(Integer.parseInt(q));
            }
        }
        return s.pop();
    }
}