class Solution {
    public boolean checkIfExist(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                // Ensure i != j and check the condition arr[i] == 2 * arr[j]
                if (i != j && arr[i] == 2 * arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}