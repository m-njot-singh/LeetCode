class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
         Map<Integer,String> hm = new HashMap<Integer,String>();
        for(int i=0;i<names.length;i++){
            hm.put(heights[i],names[i]);
        }
        Arrays.sort(heights);
        String[] s=new String[heights.length];
        int index=0;
        for(int i=heights.length-1;i>=0;i--){
            s[index]=hm.get(heights[i]);
            index++;
        }
        return s;
    }
}