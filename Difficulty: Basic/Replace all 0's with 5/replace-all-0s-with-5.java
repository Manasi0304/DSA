class Solution {
    int convertfive(int num) {
        // Your code here
      if(num == 0) return 5; 

        int result = 0;
        int place = 1;

        while (num > 0) {
            int digit = num % 10;
            if (digit == 0) {
                digit = 5; 
            }
            result = result + digit * place; 
            place = place * 10;
            num = num / 10;
        }

        return result;
    }
}