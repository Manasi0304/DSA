import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return arr;
        }
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        HashMap<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
        for (int num : sortedArr) {
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank++);
            }
        }
        for (int i = 0; i < n; i++) {
            arr[i] = rankMap.get(arr[i]);
        }
        
        return arr;
    }
}
