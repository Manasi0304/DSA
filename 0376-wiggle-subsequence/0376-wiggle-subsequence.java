class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n=nums.length;
        if (n < 2) {
            return n;
        }

        int high = 1, low = 1;
        int maxLength = 1;  
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                high = low + 1;  
                maxLength = high;  
            }
            else if (nums[i] < nums[i - 1]) {
                low = high + 1;  
                maxLength = low; 
            }
        }

        return maxLength;  
    }
}
