//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class meet{
        int start;
        int end;
        int pos;
        meet(int _start,int _end,int _pos){
            this.start=_start;
            this.end=_end;
            this.pos=_pos;
        }
    }
    
    class meetingComp implements Comparator<meet>{
        public int compare(meet o1,meet o2){
            if(o1.end <o2.end)return -1;
            else if (o1.end > o2.end)return 1;
            else if(o1.pos < o2.pos)return -1;
            return 1;
        }
    }
class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    
    
    public static int maxMeetings(int start[], int end[], int n)
    {
        ArrayList<meet> meeting=new ArrayList<>();
        for(int i=0;i<start.length;i++){
            meeting.add(new meet(start[i],end[i],i+1));
        }
        
        meetingComp mc=new meetingComp();
        
        Collections.sort(meeting , mc);
        ArrayList<Integer> ans=new ArrayList<>();
        ans.add(meeting.get(0).pos);
        int limit =meeting.get(0).end;
        
        for(int i=1;i<start.length;i++){
            if(meeting.get(i).start>limit){
                limit=meeting.get(i).end;
                ans.add(meeting.get(i).pos);
            }
        }
        
        // for(int i=0;i<ans.size();i++){
        //   System.out.println(ans.get(i));  
        // }
        return ans.size();
    }
}
