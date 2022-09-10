class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        long n=x;
        long num=0;
        while(n!=0){
            long rem=n%10;
             // System.out.println(rem);
            num+=rem;
            // System.out.println(num);
            num=num*10;
              // System.out.println(num);
            n=n/10;
             // System.out.println(n);
        }
        // System.out.println(num);
        if((num/10)==x)return true;
        return false;
    }
}