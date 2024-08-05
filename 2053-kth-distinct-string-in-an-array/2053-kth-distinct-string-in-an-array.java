class Solution {
    public String kthDistinct(String[] arr, int k) {
         int n = arr.length;
        String[] uniqueStr = new String[n];
        int[] count = new int[n];
        int uniqueCnt = 0;

        for (int i = 0; i < n; i++) {
            boolean found = false;
            for (int j = 0; j < uniqueCnt; j++) {
                if (arr[i].equals(uniqueStr[j])) {
                    count[j]++;
                    found = true;
                    break;
                }
            }
            if (!found) {
                uniqueStr[uniqueCnt] = arr[i];
                count[uniqueCnt] = 1;
                uniqueCnt++;
            }
        }
        int distinctCnt = 0;
        for (int i = 0; i < uniqueCnt; i++) {
            if (count[i] == 1) {
                distinctCnt++;
                if (distinctCnt == k) {
                    return uniqueStr[i];
                }
            }
        }

        return "";
 
    }
}