//{ Driver Code Starts
import java.util.Scanner;

class SquartRoot {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int a = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.floorSqrt(a));
            t--;
        }
    }
}
// } Driver Code Ends


/*You are required to complete
this function*/

// Function to find square root
// x: element to find square root
class Solution {
    int floorSqrt(int n) {
        // Your code here
        if (n == 1) return 1; 
        
        int low = 1, high = n, ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long square = (long) mid * mid; 
            
            if (square == n) {
                return mid; 
            } else if (square < n) {
                ans = mid;
                low = mid + 1; 
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
