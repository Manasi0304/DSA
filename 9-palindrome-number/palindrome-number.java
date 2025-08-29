class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int rev=reverseNumber(x);
        if(rev==x){
            return true;
        }
        return false;

    }
    public static int reverseNumber(int n){
       
        int rn=0;
        while(n!=0){
             int ld=n%10;
             rn=rn*10+ld;
             n=n/10;
        }
        return rn;

    }
    
}