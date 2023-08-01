class Solution {
    public static void rec(int op,int cl,List<String> ans,String out){
        if(op==0 && cl==0){
            ans.add(out);
            return;
        }
        if(op!=0){
            String out1=out;
            out1+="(";
            rec(op-1,cl,ans,out1);
        }
        if(cl>op){
            String out2=out;
            out2+=")";
            rec(op,cl-1,ans,out2);
        }
        return;
        
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        int open=n;
        int close=n;
        String out="";
        rec(open,close,ans,out);
        return ans;
    }
}