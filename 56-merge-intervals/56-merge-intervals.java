class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1){
            return intervals;
        }
        List<int[]> ans=new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],b[0]));
                    for(int i=0;i<intervals.length;i++){
                       int [] newarr=intervals[i];
                        while(i+1<intervals.length && newarr[1]>=intervals[i+1][0]){
                            newarr[1]=Math.max(newarr[1],intervals[i+1][1]);
                            i++;
                        }
                        ans.add(newarr);
                    }
                    return ans.toArray(new int[ans.size()][]);
    }
}