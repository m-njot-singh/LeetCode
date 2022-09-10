class Solution {
    public int[] plusOne(int[] digits) {
        int len=digits.length;
        // System.out.println(len);
        for(int i=len-1;i>=0;i--){
            if( digits[i]<=8){
            digits[i]++; 
            return digits;
        }
            digits[i]=0;
        }
        int [] num=new int[len+1];
        num[0]=1;
        return num;
      
    }
}