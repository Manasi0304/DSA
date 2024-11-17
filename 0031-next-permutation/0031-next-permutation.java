import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = -1;
        
        // Step 1: Find the pivot 
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }

        // Step 2: If no pivot is found, reverse the entire array
        if (pivot == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // Step 3: Find the next larger number than nums pivot from the right
        for (int i = n - 1; i > pivot; i--) {
            if (nums[i] > nums[pivot]) {
                swap(nums, i, pivot);
                break;
            }
        }

        // Step 4: Reverse the suffix starting after the pivot
        reverse(nums, pivot + 1, n - 1);
    }

     private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

   
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
