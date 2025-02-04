//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        while (t-- > 0) {
            String s = br.readLine();

            Solution obj = new Solution();

            System.out.println(obj.findSum(s));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends




class Solution {
    // Function to calculate sum of all numbers present in a string.
    public static int findSum(String s) {
        // your code here
        
        int currentNum=0;
        int sum=0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);  
            
            if (Character.isDigit(ch)) {
                currentNum = currentNum * 10 + (ch - '0');
            } else {
                sum=sum+ currentNum;
                currentNum = 0;  
            }
        }
        sum = sum+ currentNum;
        
        return sum;
    }
}