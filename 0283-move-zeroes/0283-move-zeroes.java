public class Solution {
    public void moveZeroes(int[] nums) {
        int NonZeroInd = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != NonZeroInd) {
                    int temp = nums[NonZeroInd];
                    nums[NonZeroInd] = nums[i];
                    nums[i] = temp;
                }
                NonZeroInd++; 
            }
        }
    }
}
