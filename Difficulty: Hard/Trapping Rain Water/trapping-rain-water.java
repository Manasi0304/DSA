//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxWater(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int maxWater(int arr[]) {
        // code here
        int left = 0, right = arr.length - 1;
        int leftMax = 0, rightMax = 0, waterTrapped = 0;

        while (left <= right) {
            if (arr[left] <= arr[right]) {
                if (arr[left] >= leftMax) {
                    leftMax = arr[left]; // Update left max
                } else {
                    waterTrapped += leftMax - arr[left]; // Water trapped at left
                }
                left++;
            } else {
                if (arr[right] >= rightMax) {
                    rightMax = arr[right]; // Update right max
                } else {
                    waterTrapped += rightMax - arr[right]; // Water trapped at right
                }
                right--;
            }
        }
        return waterTrapped;
    }
}
