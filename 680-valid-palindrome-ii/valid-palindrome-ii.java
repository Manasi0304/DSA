class Solution {
    public boolean validPalindrome(String s) {
        int n=s.length();
        int start=0;
        int end=n-1;
        while(start<end){
           
            if(Character.toLowerCase(s.charAt(start))!=Character.toLowerCase(s.charAt(end))){
                return checkpal(s,start+1,end)||checkpal(s,start,end-1);
            }
        
            start++;
            end--;
        }
        return true;
    }
    public boolean checkpal(String s , int start, int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
                
            }
            start++;
            end--;
            
        }
        return true;
    }
}