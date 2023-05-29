//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class comp implements Comparator<ArrayList<String>> {
    // override the compare() method
    public int compare(ArrayList<String> a, ArrayList<String> b)
    {
        String x = "";
        String y = "";
        for(int i=0; i<a.size(); i++)
            x += a.get(i);
        for(int i=0; i<b.size(); i++)
            y += b.get(i);
        return x.compareTo(y);
    }
}

public class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<ArrayList<String>> ans = obj.findSequences(startWord, targetWord, wordList);
            if(ans.size()==0)
                System.out.println(-1);
            else
            {
                Collections.sort(ans, new comp());
                for(int i=0; i<ans.size(); i++)
                {
                    for(int j=0; j<ans.get(i).size(); j++)
                    {
                        System.out.print(ans.get(i).get(j) + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public ArrayList<ArrayList<String>> findSequences(String beginWord, String endWord, String[] wordList)
    {
        // Code here
        
        
        Set<String> set=new HashSet<>();
        for(String a:wordList){
            set.add(a);
        }
        
        ArrayList<ArrayList<String>> ans=new ArrayList<>();
        ArrayList<String> l=new ArrayList<>();
        ArrayList<String> ls=new ArrayList<>();
        ls.add(beginWord);
        Queue<ArrayList<String>> q=new LinkedList<>();
        l.add(beginWord);
        q.add(ls);
        int level=0;
        
        while(!q.isEmpty()){
            
            ArrayList<String> temp=q.peek();
            q.remove();
            if(temp.size()>level){
                level++;
                for(String a:l){
                    set.remove(a);
                }
            }
            
            String last=temp.get(temp.size()-1);
            if(last.equals(endWord)){
                if(ans.size()==0){
                    ans.add(temp);
                }
                else if(ans.get(0).size()==temp.size()){
                    ans.add(temp);
                }
            }
            for(int i=0;i<last.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] charArr=last.toCharArray();
                    charArr[i]=ch;
                    String s=new String(charArr);
                    if(set.contains(s)==true){
                        temp.add(s);
                        ArrayList<String> t1=new ArrayList<>(temp);
                        q.add(t1);
                        l.add(s);
                        temp.remove(temp.size()-1);
                    }
                }
            }
        }
        return ans;
    }
}