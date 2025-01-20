//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().majorityElement(arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int majorityElement(int arr[]) {
        // your code here
        int n = arr.length;
        int majority = -1;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (count == 0) {
                majority = arr[i];
                count = 1;
            } else if (arr[i] == majority) {
                count++;
            } else {
                count--;
            }
        }

        count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == majority) {
                count++;
            }
        }
        if (count > n / 2) {
            return majority;
        } else {
            return -1; // No majority element found
        }
    
    }
}