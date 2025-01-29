//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // First array input (arr)
            String[] str1 = br.readLine().trim().split(
                " "); // Read the first line and split by spaces
            int n = str1.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] =
                    Integer.parseInt(str1[i]); // Convert each element to an integer
            }

            // Second array input (dep)
            String[] str2 = br.readLine().trim().split(
                " "); // Read the second line and split by spaces
            int m = str2.length;
            int[] dep = new int[m];
            for (int i = 0; i < m; i++) {
                dep[i] =
                    Integer.parseInt(str2[i]); // Convert each element to an integer
            }

            Solution obj = new Solution();
            System.out.println(obj.findPlatform(arr, dep));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends
class Solution {
    // Function to find the minimum number of platforms required at the
    static int findPlatform(int arr[], int dep[]) {
        // add your code here
       // Sort arrival and departure arrays
        Arrays.sort(arr);
        Arrays.sort(dep);

        // Initialize pointers for arrival and departure arrays
        int i = 1, j = 0;
        
        // Initialize variables
        int platforms_needed = 1;
        int result = 1;
        int n = arr.length; 
        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                platforms_needed++;
                i++;
            } 
            else {
                platforms_needed--;
                j++;
            }
            result = Math.max(result, platforms_needed);
        }
        return result;
    }
}
