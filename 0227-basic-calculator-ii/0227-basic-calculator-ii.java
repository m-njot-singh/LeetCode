class Solution {
    public static int prec(char c){
        if(c=='+' || c=='-')return 1;
        else if(c=='*' || c=='/')return 2;
        return 0;
    }
    public int calculate(String s) {
        Stack<Integer> num=new Stack<>();
        Stack<Character> ch=new Stack<>();
        int digit=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9'){
                    digit=digit*10+s.charAt(i)-'0';
                    i++;
                }
                i--;
                num.push(digit);
                digit=0;
            }
            else if(s.charAt(i)=='/' || s.charAt(i)=='*' || s.charAt(i)=='-' || s.charAt(i)=='+' ){
                while(!num.isEmpty() && !ch.isEmpty() && prec(ch.peek())>=prec(s.charAt(i))){
                int val1=num.peek();
                num.pop();
                int val2=num.peek();
                num.pop();
                if(ch.peek()=='+'){
                    num.push(val2+val1);
                    ch.pop();
                }
                else if(ch.peek()=='-'){
                    num.push(val2-val1);
                    ch.pop();
                }
                else if(ch.peek()=='/'){
                    num.push(val2/val1);
                    ch.pop();
                }
                else if(ch.peek()=='*'){
                    num.push(val2*val1);
                    ch.pop();
                }
        }
                ch.push(s.charAt(i));
            }
        }
        
        while(!num.isEmpty() && !ch.isEmpty()){
            int val1=num.peek();
            num.pop();
            int val2=num.peek();
            num.pop();
            if(ch.peek()=='+'){
                num.push(val2+val1);
                ch.pop();
            }
            else if(ch.peek()=='-'){
                num.push(val2-val1);
                ch.pop();
            }
            else if(ch.peek()=='/'){
                num.push(val2/val1);
                ch.pop();
            }
            else if(ch.peek()=='*'){
                num.push(val2*val1);
                ch.pop();
            }
        }
        return num.peek();
    }
}