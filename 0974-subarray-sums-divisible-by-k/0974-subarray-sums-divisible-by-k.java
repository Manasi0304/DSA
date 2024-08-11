class Solution {
    public int subarraysDivByK(int[] nums, int k) {
         Map<Integer, Integer> remainderCount = new HashMap<>();
        remainderCount.put(0, 1); // To account for subarrays that start from the beginning and are divisible by k

        int count = 0;
        int prefixSum = 0;

        for (int num : nums) {
            prefixSum += num;
            int remainder = prefixSum % k;

            // Adjust remainder to be positive
            if (remainder < 0) {
                remainder += k;
            }

            if (remainderCount.containsKey(remainder)) {
                count += remainderCount.get(remainder);
            }

            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }
}