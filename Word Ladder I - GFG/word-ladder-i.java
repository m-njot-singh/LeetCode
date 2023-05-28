//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
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
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends

class Pair{
    String first;
    int second;
    Pair(String _first,int _second){
        this.first=_first;
        this.second=_second;
    }
}
class Solution
{
     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(beginWord,1));
        
        while(!q.isEmpty()){
            String node=q.peek().first;
            int sum=q.peek().second;
            q.remove();
            if(node.equals(endWord)==true)return sum;
            for(int i=0;i<node.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char newstring[]= node.toCharArray();
                    newstring[i]=ch;
                    String s=new String(newstring);
                    if(wordList.contains(s)==true){
                        wordList.remove(s);
                        q.add(new Pair(s,sum+1));
                    }
                }
            }
            
        }
        return 0;
    }
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        // Code here
        List<String> l=new ArrayList<>();
        for(String a:wordList){
            l.add(a);
        }
        return ladderLength(startWord,targetWord,l);
    }
}