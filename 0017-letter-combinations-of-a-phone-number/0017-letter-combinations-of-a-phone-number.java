class Solution {
    public static void rec(int i,int n,String digits,Map<Integer,String> map,StringBuilder temp,List<String> l){
        if(i>=n ){
            if(temp.length()>0){
                l.add(temp.toString());
            }
            
            return;
        }
        int a=digits.charAt(i)-'0';
        String s=map.get(a);
        for(int q=0;q<s.length();q++){
            temp.append(s.charAt(q));
            rec(i+1,n,digits,map,temp,l);
            temp.deleteCharAt(temp.length() - 1);
        }
        
        
    }
    public List<String> letterCombinations(String digits) {
        List<String> l=new ArrayList<>();
        String[] s={"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        Map<Integer,String> map=new HashMap<>();
        for(int i=2;i<10;i++){
            map.put(i,s[i-2]);
        }
        StringBuilder sa=new StringBuilder();
        rec(0,digits.length(),digits,map,sa,l);
        return l;
        
    }
}