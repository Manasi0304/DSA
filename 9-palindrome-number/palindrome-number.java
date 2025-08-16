class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int div=1;
        while(x/div>=10){
            div=div*10;
        }
        while(x!=0){
            int first=x/div;
            int last=x%10;
            if(first!=last){
                return false;
            }
            x=x%div;
            x=x/10;
            div=div/100;
        }
        return true;
    }
    
}