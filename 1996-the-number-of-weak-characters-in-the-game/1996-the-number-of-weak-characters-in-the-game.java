class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
         Arrays.sort(properties, (a,b) -> (a[0] == b[0]) ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));
//          for (int i = 0; i < properties.length; i++){
 
//             // Loop through all elements of current row
//             for (int j = 0; j < properties[i].length; j++)
//                 System.out.print(properties[i][j] + " ");
//     }
        int count=0;
        int len=properties.length;
     int max=properties[len-1][1];
       
//     for(int j=len-1;j>=0;j--){
        
//         for (int i=j-1;i>=0;i--){
//             if(properties[i][1]>max){
//                 count++;
//                 System.out.println(count);
//                 break;
//             }
//             // else{
//             //     max=properties[i][1];
//             // }
//         }
//         if(j>0){
//             max=properties[j-1][1];
//         }
        
//     }
        
         for(int i = len-2; i>=0 ;i--) {
            
            if(properties[i][1] < max) {
                count++;
            } else {
                max = properties[i][1];
            }
        }
        
        return count;
    }
}