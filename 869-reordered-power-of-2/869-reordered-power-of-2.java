class Solution {
    public boolean reorderedPowerOf2(int n) {
        List<String> v=new ArrayList<String>();
        for(int i=0;i<31;i++){
            int p=(int)Math.pow(2,i);
            String ps=Integer.toString(p);
            char[] chArr = ps.toCharArray();
            Arrays.sort(chArr);
            String a=new String(chArr);
            v.add((a));
            //System.out.println(v.get(i));
        }
        String s=Integer.toString(n);
        char[] Arr=s.toCharArray();
        Arrays.sort(Arr);
        String b=new String(Arr);
        
        
        return v.contains(b);
        
    }
}