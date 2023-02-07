class mypair{
    int x;
    int y;
    mypair(int a,int b){
        x=a;
        y=b;
    }
}


class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<mypair> pq=new PriorityQueue<mypair>((a,b) -> (a.x*a.x + a.y*a.y)-(b.x*b.x+b.y*b.y) );
        for(int i=0;i<points.length;i++){
            pq.add(new mypair(points[i][0],points[i][1]));
        }
        
        int [][] ans=new int[k][2];
        
        for(int i=0;i<k;i++){
            mypair val=pq.poll();
            ans[i][0]=val.x;
            ans[i][1]=val.y;
        }
        
        
        return ans;
    }
}