// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    System.out.println(new Solution().evaluatePostFix(br.readLine().trim()));
		}
	}
}// } Driver Code Ends


class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S)
    {
        // Your code here
       
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<S.length();i++){ 
            if(S.charAt(i)=='+'){
                int a=(int)st.pop();
                int b=(int)st.pop();
                st.push(a+b);
            }
            else if(S.charAt(i)=='-'){
               
                int b=(int)st.pop();
                int a=(int)st.pop();
                st.push(a-b);
            }
            else if(S.charAt(i)=='*'){
                int a=(int)st.pop();
                int b=(int)st.pop();
                st.push(a*b);
            }
            else if(S.charAt(i)=='/'){
                 
                int b=(int)st.pop();
                int a=(int)st.pop();
                st.push(a/b);
            }
            else{
                // System.out.println(S.charAt(i));
                st.push(Character.getNumericValue(S.charAt(i)));
            }
            
                // System.out.println(st.peek());
            
        }
        return st.pop();
    }
}