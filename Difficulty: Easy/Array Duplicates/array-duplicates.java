//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        for (int g = 0; g < t; g++) {
            String[] str =
                (br.readLine()).trim().split(" "); // Reading input as a string array
            int arr[] = new int[str.length]; // Creating integer array from the input
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            // Getting the result from the Solution class
            List<Integer> result = new Solution().findDuplicates(arr);
            Collections.sort(result);
            // Printing the result in the required format
            if (result.isEmpty()) {
                System.out.println("[]");
            } else {
                for (int i = 0; i < result.size(); i++) {
                    if (i != 0) System.out.print(" ");
                    System.out.print(result.get(i));
                }
                System.out.println();
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public List<Integer> findDuplicates(int[] arr) {
        // code here
        int n = arr.length;

        int[] count = new int[n + 1]; // Assuming numbers in the array are in the range [0, n]
        List<Integer> duplicates = new ArrayList<>();
    
        
        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0 && arr[i] <= n) { 
                count[arr[i]]++;
            }
        }
    
        for (int i = 0; i <= n; i++) {
            if (count[i] > 1) {
                duplicates.add(i);
            }
        }
    
        return duplicates;
    }
}
