// User function Template for Java

class Solution {
    public long find_fact(int n) {
        // Code here
        long facto=1;
        for(int i=2;i<=n;i++){
           
            facto=facto*i;
        }
        return facto;
    }
}