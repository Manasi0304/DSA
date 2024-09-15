
class Solution {
    public void sortColors(int[] nums) {
         int count0 = 0, count1 = 0, count2 = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                count0++;
            } else if (nums[i] == 1) {
                count1++;
            } else {
                count2++;
            }
        }

        int index = 0;
        for (int i = 0; i < count0; i++) {
            nums[index++] = 0;
        }
        for (int i = 0; i < count1; i++) {
            nums[index++] = 1;
        }
        for (int i = 0; i < count2; i++) {
            nums[index++] = 2;
        }
    }
}
        
  