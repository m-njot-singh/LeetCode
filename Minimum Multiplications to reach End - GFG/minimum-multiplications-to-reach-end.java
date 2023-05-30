//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair{
    int step;
    int node;
    Pair(int _step,int _node){
        this.step=_step;
        this.node=_node;
    }
}
class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        Queue<Pair> pq=new LinkedList<>();
        pq.add(new Pair(0,start));
        
        int[] dis=new int[100000];
        for(int i=0;i<100000;i++){
            dis[i]=(int)1e9;
        }
        dis[start]=0;
        int mod=100000;
        while(!pq.isEmpty()){
            Pair itr=pq.peek();
            pq.remove();
            int step=itr.step;
            int node=itr.node;
            
            for(int i=0;i<arr.length;i++){
                int num=(arr[i]*node)%mod;
                if(step+1<dis[num]){
                    dis[num]=step+1;
                    if(num==end)return step+1;
                    pq.add(new Pair(step+1,num));
                }
            }
            
        }
        return -1;
        
    }
}
