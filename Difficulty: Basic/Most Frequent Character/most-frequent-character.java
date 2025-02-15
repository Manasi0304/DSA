//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String line = br.readLine().trim();

            Solution obj = new Solution();

            System.out.println(obj.getMaxOccuringChar(line));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    // Function to find the maximum occurring character in a string.
    public static char getMaxOccuringChar(String s) {
        // Your code here
        int freq[]=new int[256];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)]++;
        }
        int maxFreq=0;
       
         char result = ' ';
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            
            if (freq[c] > maxFreq || (freq[c] == maxFreq && c < result)) {
                maxFreq = freq[c];
                result = c;
            }
        }
        return result;
    }
}