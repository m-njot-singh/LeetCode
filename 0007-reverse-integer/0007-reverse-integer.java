class Solution {
    public int reverse(int x) {
//         long ans=0;
//         int flag=0;
//         if(x>0){
//             flag=1;
//             while(x>0){
//             ans+=(long)x%10;
//             ans*=10;
//             x=x/10;
//             if(x<(-Math.pow(2,31)) || x>(Math.pow(2,31)-1))return 0;
//         }
//         }
//         else if(x==0){
//             return 0;
//         }
//         else{
//             x=-x;
//             while(x>0){
//             ans+=(long)x%10;
//             ans*=10;
//             x=x/10;
//             if(x<(-Math.pow(2,31)) || x>(Math.pow(2,31)-1))return 0;
//         }
            
            
//         }
//         if(flag==1)return (int)(ans)/10;
//         return (int)(-ans)/10;
         long rev= 0;
        while( x != 0){
            rev= rev*10 + x % 10;
            // System.out.println((x%10)+" "+rev);
            x= x/10;
            if( rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE)
                return 0;
        }
        return (int) rev;
    }
}