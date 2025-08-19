class Solution {
    public int num(int k, int arr[]) {
        // code here
        int n=arr.length;
        int count=0;
        for (int i = 0; i < n; i++) {
            int num = arr[i]; 
            if (num == 0 && k == 0) { 
                count++;
            }

            while (num > 0) {
                int ld = num % 10;
                if (ld == k) {
                    count++;
                }
                num = num / 10;
            }
        }
        return count;
    }
}