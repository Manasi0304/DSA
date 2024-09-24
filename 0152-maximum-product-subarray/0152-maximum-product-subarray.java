class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxProduct = nums[0];
        int currMax = nums[0];
        int currMin = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] < 0) {
                int temp = currMax;
                currMax = currMin;
                currMin = temp;
            }
            if (nums[i] > currMax * nums[i]) {
                currMax = nums[i];
            } else {
                currMax = currMax * nums[i];
            }
            if (nums[i] < currMin * nums[i]) {
                currMin = nums[i];
            } else {
                currMin = currMin * nums[i];
            }
            if (currMax > maxProduct) {
                maxProduct = currMax;
            }
        }

        return maxProduct;
    }
}
