//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static List<Integer> dfs(List<List<Integer>> adj,int K){
        int indegree[] =new int[K];
        for(int i=0;i<K;i++){
            for(int a:adj.get(i)){
                indegree[a]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<K;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        
        List<Integer> l=new ArrayList<>();
        while(!q.isEmpty()){
            int w=q.peek();
            q.remove();
            l.add(w);
            for(int a:adj.get(w)){
                indegree[a]--;
                if(indegree[a]==0){
                    q.add(a);
                }
            }
        }
        
        return l;
    }
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<K;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<N-1;i++){
            String a=dict[i];
            String b=dict[i+1];
            for(int j=0;j<Math.min(a.length(),b.length());j++){
                if(a.charAt(j)!=b.charAt(j)){
                    adj.get(a.charAt(j)-'a').add(b.charAt(j)-'a');
                    break;
                }
            }
        }
        List<Integer> l=dfs(adj,K);
        
        
        String ans="";
        for(int r:l){
            ans+=(char)(r+(int)('a'));
        }
        return ans;
    }
}