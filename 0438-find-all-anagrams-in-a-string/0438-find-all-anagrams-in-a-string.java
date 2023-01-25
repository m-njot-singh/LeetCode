class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans=new ArrayList<>();
        int q=0;
        char[] strArray = p.toCharArray();
        Arrays.sort(strArray);
        // String ans1=strArray.toString();
        // System.out.print(strArray.toString());
        int k=p.length();
        int i=0;
        int j=i+p.length();
        while(j<=s.length()){
            String a=s.substring(i,j);
           char[] arr=a.toCharArray();
            Arrays.sort(arr);
            if(Arrays.equals(arr, strArray)){
                ans.add(i);
            } 
            i++;
            j++;
        
    }
    return ans;
  }

}