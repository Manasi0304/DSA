class Solution {
    int missingNum(int arr[]) {
        // code here
        int n = arr.length + 1; 
        int xor = 0; 

        for (int i = 0; i < arr.length; i++) {
            xor = xor ^ arr[i];      
            xor = xor ^(i + 1);   
        }
        xor = xor^n;

        return xor;
        
    }
}