class Solution {
    public int thirdMax(int[] nums) {
          
        Integer max1 = null, max2 = null, max3 = null;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if ((max1 != null && num == max1) || 
                (max2 != null && num == max2) || 
                (max3 != null && num == max3)) {
                continue;
            }
            if (max1 == null || num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (max2 == null || num > max2) {
                max3 = max2;
                max2 = num;
            } else if (max3 == null || num > max3) {
                max3 = num;
            }
        }

        if (max3 == null) {
            return max1;
        }
        return max3;
    }
}